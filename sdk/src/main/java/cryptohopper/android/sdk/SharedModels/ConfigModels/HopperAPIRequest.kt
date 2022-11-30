//
//  HopperAPIRequest.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.Settings.Secure
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


open class HopperAPIRequest<Object> {

    var path: String = "/"

    var httpMethod: HopperAPIHttpMethod = HopperAPIHttpMethod.GET

    var needsAuthentication: Boolean = false

    var isAuthenticationRequest: Boolean = false

    var isV2Api: Boolean = false

    var client = OkHttpClient.Builder()
        .connectionSpecs(
            listOf(
                ConnectionSpec.MODERN_TLS,
                ConnectionSpec.COMPATIBLE_TLS
            )
        )
        .build()

    var httpHeaders: MutableMap<String, String>? = null
    var queryItems: MutableMap<String, String>? = null
    var bodyItems: MutableMap<String, Any>? = null


    val url: String = ""

    fun setIsAuthenticationRequest(isAuthenticationMethod: Boolean) {
        this.isAuthenticationRequest = isAuthenticationMethod
    }

    fun addHeader(name: String, value: String) {
        if (httpHeaders == null) {
            httpHeaders = mutableMapOf<String, String>()
            httpHeaders?.set("Content-Type", "application/json")
            httpHeaders?.set("Accept", "application/json")
        }
        httpHeaders?.set(name, value)
    }

    fun changeUrlPath(path: String, isV2Endpoint : Boolean = false) {
        this.path = path
        this.isV2Api = isV2Endpoint
    }

    fun addQueryItem(name: String, value: String) {
        if (queryItems == null) {
            queryItems = mutableMapOf<String, String>()
        }
        queryItems?.set(name, value)
    }

    fun addBodyItem(name: String, value: Any) {
        if (bodyItems == null) {
            bodyItems = mutableMapOf<String, Any>()
        }
        bodyItems?.set(name, value)
    }

    fun handleError(failClosure: (HopperAPIError) -> Unit?, error: HopperError) {
        if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
            print(error)
        }
        val err = HopperAPIError(0, "Unkown response error occured", 0,null)
        err.error = error
        failClosure.invoke(err)
    }

    fun createUrl(): String {
        var reqUrl = ""

        val configHost: String = when {
            this.isAuthenticationRequest -> HopperAPIConfigurationManager.shared.config.authenticationHost
            this.isV2Api -> HopperAPIConfigurationManager.shared.config.v2Host
            else -> HopperAPIConfigurationManager.shared.config.host
        }

        val builder: Uri.Builder = Uri.Builder()
        val scheme = builder.scheme(HopperAPIConfigurationManager.shared.config.urlScheme)
            .authority(configHost)
            .appendPath(this.path)
        this.queryItems?.forEach { map ->
            scheme.appendQueryParameter(map.key, map.value)
        }
        reqUrl = scheme.build().toString()

        return reqUrl
    }

    fun generateRequest(url: String): Request {
        val urlTwoF = url.replace("%2F", "/")
        val newUrl = urlTwoF.replace("//", "/")
        val reqBuilder = Request.Builder().url(newUrl)
        httpHeaders?.forEach { map ->
            reqBuilder.addHeader(map.key, map.value)
        }

        when (httpMethod) {
            HopperAPIHttpMethod.POST -> {
                val reqBody = Gson().toJson(bodyItems).toString().toRequestBody()
                return reqBuilder.post(reqBody).build()
            }
            HopperAPIHttpMethod.PATCH -> {
                val reqBody = Gson().toJson(bodyItems).toString().toRequestBody()
                return reqBuilder.patch(reqBody).build()
            }
            HopperAPIHttpMethod.PUT -> {
                val reqBody = Gson().toJson(bodyItems).toString().toRequestBody()
                return reqBuilder.put(reqBody).build()
            }
            HopperAPIHttpMethod.DELETE -> {
                val reqBody = Gson().toJson(bodyItems).toString().toRequestBody()
                return reqBuilder.delete(reqBody).build()
            }
            HopperAPIHttpMethod.GET -> {
                return reqBuilder.get().build()
            }
        }
    }

    inline fun <reified T> Gson.fromJsonType(json: String): T {
        val tt = object : TypeToken<T>() {}.type;
        println(tt);
        return fromJson(json, tt);
    }

    inline fun <reified T : Any> startRequest(
        onSuccess: (T) -> Unit?,
        noinline onFail: (HopperAPIError) -> Unit?
    ) {
        try {
            val url = createUrl()

            if (url == "") {
                this.handleError(failClosure = onFail, error = HopperError.MISSING_URL)
                return
            }

            val request = generateRequest(url = url)

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                        print("API ERROR RESPONSE :" + response.body?.string() ?: "No response")
                    }
                    onFail.invoke(
                        HopperAPIError(
                            response.code,
                            response.body?.string() ?: "No response",
                            0,
                            null
                        )
                    )
                } else {
                    if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                        print("API RESPONSE :" + response.body.toString())
                    }

                    if (response != null) {
                        if (response.code in 200..299) {
                            val responseString = response.body!!.string()
                            var commonResponse: HopperCommonMessageResponse? = null
                            try {
                                commonResponse =
                                    Gson().fromJsonType<HopperCommonMessageResponse>(responseString)
                            } catch (e: JsonParseException) {
                            }

                            if (commonResponse != null) {
                                if (commonResponse.error != null && commonResponse.status != null) {
                                    if(commonResponse.status == 402){
                                        sendDeviceUnauthorized()
                                    }
                                    Log.d(
                                        "HOPPER ERROR : ",
                                        commonResponse.message ?: "No error message"
                                    )
                                    val err = HopperAPIError(
                                        (commonResponse.error ?: 0),
                                        commonResponse.message,
                                        (commonResponse.status?: 0),
                                        commonResponse.code ?: 0
                                    )
                                    err.error = HopperError.UNKOWN_ERROR
                                    onFail(err)
                                } else {
                                    val jsonResponse = Gson().fromJsonType<T>(responseString)
                                    onSuccess(jsonResponse)
                                }
                            } else {
                                val jsonResponse = Gson().fromJsonType<T>(responseString)
                                onSuccess(jsonResponse)
                            }
                        } else {
                            if(response.code == 402){
                                sendDeviceUnauthorized()
                            }
                            val jsonResponse = Gson().fromJson(
                                response.body!!.string(),
                                HopperAPIError::class.java
                            )
                            onFail(jsonResponse)
                        }
                    } else {
                        if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                            print("RESPONSE NULL")
                        }
                        val err = HopperAPIError(0, "Unkown response error occured", 0,null)
                        err.error = HopperError.UNKOWN_ERROR
                        onFail(err)
                    }
                }
            }
        } catch (e: Exception) {
            val err = HopperAPIError(0, "Unkown response error occured", 0,null)
            err.error = HopperError.UNKOWN_ERROR
            onFail(err)
        }
    }

    inline fun <reified T : Any> request(
        noinline onSuccess: (T) -> Unit?,
        noinline onFail: (HopperAPIError) -> Unit?
    ) {
        this.addRequiredHeaders()
        
        if(isV2Api){
            this.addV2Headers()
        }

        if (needsAuthentication) {
            this.authenticateAndRequestAgain(onSuccess, onFail)
        } else {
            try {
                startRequest<T>({ response ->
                    onSuccess.invoke(response)
                }) { error ->
                    val err = error as? HopperAPIError
                    if (err != null) {
                        when (err.error) {
                            HopperError.ACCESS_TOKEN_EXPIRED, HopperError.INVALID_ACCESS_TOKEN, HopperError.INVALID_SESSION -> {
                                this.authenticateAndRequestAgain(
                                    onSuccess,
                                    onFail
                                )
                            }
                            else -> {
                                onFail.invoke(err)
                            }
                        }
                    } else {
                        val err = HopperAPIError(0, "Unkown response error occured", 0,null)
                        err.error = HopperError.UNKOWN_ERROR
                        onFail.invoke(err)
                    }
                }
            } catch (e: Exception) {
                val err = HopperAPIError(0, "Unkown response error occured", 0,null)
                err.error = HopperError.UNKOWN_ERROR
                onFail.invoke(err)
            }
        }
    }

    fun sendDeviceUnauthorized(){
        val userDataChanaged = Intent("CH_UNAUTHORIZED_DEVICE")
        LocalBroadcastManager.getInstance(HopperAPIConfigurationManager.shared.config.context!!).sendBroadcast(userDataChanaged)
    }

    fun addV2Headers(){
        this.addHeader(HopperAPIConfigurationManager.shared.config.v2ApiValidationKey,  HopperAPIConfigurationManager.shared.config.v2ApiValidationValue)
    }

    @SuppressLint("HardwareIds")
    fun addRequiredHeaders(){
        // Required for Security(User Device and Platform check)
        this.addHeader("Platform","Android")
        this.addHeader("x-ch-mobile-jfgmvo", "?++&>VHA[<!9iPh(kwZ#/|{}qW}M=AP$")
        val android_id = Secure.getString(
            HopperAPIConfigurationManager.shared.config.context!!.contentResolver,
            Secure.ANDROID_ID
        )
        this.addHeader("DeviceId",android_id)
    }

    inline fun <reified T : Any> authenticateAndRequestAgain(
        crossinline onSuccess: (T) -> Unit?,
        noinline onFail: (HopperAPIError) -> Unit?
    ) {
        HopperAPISessionManager.shared.checkAuthentication(onSuccess = {
            val accessToken = HopperAPISessionManager.shared.session?.accessToken
            if (accessToken == null) {
                this.handleError(failClosure = onFail, error = HopperError.MISSING_ACCESS_TOKEN)
                return@checkAuthentication
            }

            if(this.isV2Api){
                this.addHeader( "Auth-Type",  "oauth")
                this.addHeader("Authorization", "Bearer $accessToken")
            }else{
                this.addHeader("access-token", accessToken)
            }

            this.startRequest(onSuccess, onFail)
        }, onFail = onFail)
    }

}

