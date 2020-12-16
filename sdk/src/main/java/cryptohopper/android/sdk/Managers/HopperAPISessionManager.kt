

//
//  HopperAPISessionManager.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//


import android.content.Context
import java.util.*

class HopperAPISessionManager {

    companion object {
        val shared = HopperAPISessionManager()
    }

    private constructor() {}

    var session: HopperAPISession?
        get() {
            val clientId = HopperAPIConfigurationManager.shared.config.clientId ?: return null
            val sharedPref = HopperAPIConfigurationManager.shared.config.context?.getSharedPreferences("cryptohopper-android-group", Context.MODE_PRIVATE) ?: return null
            val aToken = sharedPref.getString("$clientId#AccessToken","")
            if(aToken == "" || aToken == null){
                return null
            }
            val rToken = sharedPref.getString("$clientId#RefreshToken","")
            val aTokenDate = sharedPref.getLong("$clientId#AccessTokenExpiresAt",0)
            val hSession = HopperAPISession(aToken ?: "",rToken ?: "",Date(aTokenDate))
            return hSession
        }
        set(newValue) {
            val clientId = HopperAPIConfigurationManager.shared.config.clientId ?: return
            val sharedPref = HopperAPIConfigurationManager.shared.config.context?.getSharedPreferences("cryptohopper-android-group", Context.MODE_PRIVATE)
            with (sharedPref?.edit()) {
                if (newValue != null) {
                    this?.putString("$clientId#AccessToken",newValue.accessToken)
                    this?.putString("$clientId#RefreshToken",newValue.refreshToken)
                    newValue.accessTokenExpiresAt?.time?.let { this?.putLong("$clientId#AccessTokenExpiresAt", it) }
                }else{
                    this?.remove("$clientId#AccessToken")
                    this?.remove("$clientId#AccessTokenExpiresAt")
                    this?.remove("$clientId#AccessTokenExpiresAt")
                }
                this?.apply()
            }
        }



    val hasSession: Boolean
        get() {
            return session != null
        }

    fun checkAuthentication(onSuccess: () -> Unit, onFail: ((HopperError) -> Unit?)? = null) {
        if (hasSession) {
            updateRefreshTokenIfNeeded(onSuccess = onSuccess, onFail = onFail)
        } else {
            onFail?.invoke(HopperError.MISSING_REFRESH_TOKEN)
        }
    }

    fun removeSession() {
        session = null
    }

    fun updateRefreshTokenIfNeeded(onSuccess: () -> Unit, onFail: ((HopperError) -> Unit?)? = null) {
        val refreshDate = session?.accessTokenExpiresAt ?: Date()
        val currentDate = Date()
        if (currentDate > refreshDate) {
            val refreshToken = session?.refreshToken
            if (refreshToken == null) {
                onFail?.invoke(HopperError.MISSING_REFRESH_TOKEN)
                return
            }
            HopperAPIRefreshTokenRequest(refreshToken).request({ response ->
                this.handleAuthResponse(response)
                onSuccess()
            },onFail!!)
        } else {
            onSuccess()
        }
    }

    fun handleAuthResponse(response: HopperAPIAuthenticationResponse) {
        val today = Date();
        var nextYear = Date(today.time + (1000 * 60 * 60 * 24 * 365));
        this.session = HopperAPISession(accessToken = response.accessToken
                ?: "", refreshToken = response.accessToken ?: "", accessTokenExpiresAt = nextYear)
    }

}