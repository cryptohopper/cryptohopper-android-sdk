
//
//  HopperAPIRequest.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//



import android.net.Uri
import android.util.Log
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

    var client = OkHttpClient.Builder()
        .connectionSpecs(
                listOf(
                        ConnectionSpec.MODERN_TLS,
                        ConnectionSpec.COMPATIBLE_TLS
                )
        )
        .build()

    var httpHeaders: MutableMap<String, String>? =  null
    var queryItems: MutableMap<String, String>? = null
    var bodyItems: MutableMap<String, Any>? = null


    val url: String? = ""

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

    fun changeUrlPath(path: String) {
        this.path = path
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

    fun handleError(failClosure: (HopperError) -> Unit?, error: HopperError) {
        if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
            print(error)
        }
        failClosure.invoke(error)
    }

    fun createUrl() : String {
        var reqUrl = ""

        if(this.isAuthenticationRequest){
            val builder: Uri.Builder = Uri.Builder()
            val scheme = builder.scheme(HopperAPIConfigurationManager.shared.config.urlScheme)
                .authority(HopperAPIConfigurationManager.shared.config.authenticationHost)
                .appendPath(this.path)
            this.queryItems?.forEach { map ->
                scheme.appendQueryParameter(map.key, map.value)
            }
            reqUrl = scheme.build().toString()
        }else{
            val builder: Uri.Builder = Uri.Builder()
            val scheme = builder.scheme(HopperAPIConfigurationManager.shared.config.urlScheme)
                .authority(HopperAPIConfigurationManager.shared.config.host)
                .appendPath(this.path)
            this.queryItems?.forEach { map ->
                scheme.appendQueryParameter(map.key, map.value)
            }
            reqUrl = scheme.build().toString()
        }

        return reqUrl
    }

    fun generateRequest(url: String) : Request{
        val urlTwoF = url.replace("%2F", "/")
        val newUrl = urlTwoF.replace("//", "/")
        val reqBuilder = Request.Builder().url(newUrl)
        httpHeaders?.forEach { map ->
            reqBuilder.addHeader(map.key, map.value)
        }

        when(httpMethod){
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

    inline fun <reified T : Any> startRequest(onSuccess: (T) -> Unit?, noinline onFail: (HopperError) -> Unit?) {
        val url = createUrl()
        if (url == "") {
            this.handleError(failClosure = onFail, error = HopperError.MISSING_URL)
            return
        }
        val request = generateRequest(url = url)

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful){
                if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                    print("API ERROR RESPONSE :" + response.body.toString())
                }
                onFail.invoke(HopperAPIError(response.code, response.body.toString(), 0).error!!)
            }else{
                if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                    print("API RESPONSE :" + response.body.toString())
                }

                if(response != null) {
                    if (response.code in 200..299) {
                        val responseString = response.body!!.string()
                        var commonResponse : HopperCommonMessageResponse? = null
                        try {
                            commonResponse = Gson().fromJsonType<HopperCommonMessageResponse>(responseString)
                        } catch (e: JsonParseException) { }

                        if(commonResponse != null){
                            if(commonResponse.error != null && commonResponse.status != null){
                                var err = HopperError.UNKOWN_ERROR
                                Log.d("HOPPER ERROR : ",commonResponse.message ?: "No error message")
                                onFail(err)
                            }else{
                                val jsonResponse = Gson().fromJsonType<T>(responseString)
                                onSuccess(jsonResponse)
                            }
                        }else{
                            val jsonResponse = Gson().fromJsonType<T>(responseString)
                            onSuccess(jsonResponse)
                        }
                    } else {
                        val jsonResponse = Gson().fromJson(response.body!!.string(), HopperAPIError::class.java)
                        onFail(jsonResponse.error!!)
                    }
                }else{
                    if (HopperAPIConfigurationManager.shared.config.debugModeEnabled) {
                        print("RESPONSE NULL")
                    }
                    onFail(HopperError.UNKOWN_ERROR)
                }
            }

        }
    }

    inline fun <reified T : Any> request(
            noinline onSuccess: (T) -> Unit?,
            noinline onFail: (HopperError) -> Unit?
    ) {
        if (needsAuthentication) {
            this.authenticateAndRequestAgain(onSuccess, onFail)
        } else {
            startRequest<T>({ response ->
                onSuccess.invoke(response)
            }) { error  ->
                val err = error as? HopperError
                if (err != null) {
                    when (err) {
                        HopperError.ACCESS_TOKEN_EXPIRED, HopperError.INVALID_ACCESS_TOKEN, HopperError.INVALID_SESSION -> this.authenticateAndRequestAgain(
                                onSuccess,
                                onFail
                        )
                        else -> onFail.invoke(err)
                    }
                } else {
                    onFail.invoke(HopperError.UNKOWN_ERROR)
                }
            }
        }
    }

    inline fun < reified T : Any> authenticateAndRequestAgain(
            crossinline onSuccess: (T) -> Unit?,
            noinline onFail: (HopperError) -> Unit?
    ) {
        HopperAPISessionManager.shared.checkAuthentication(onSuccess = {
            val accessToken = HopperAPISessionManager.shared.session?.accessToken
            if (accessToken == null) {
                this.handleError(failClosure = onFail, error = HopperError.MISSING_ACCESS_TOKEN)
                return@checkAuthentication
            }
            this.addHeader(name = "access-token", value = accessToken)
            this.startRequest(onSuccess, onFail)
        }, onFail = onFail)
    }

}

