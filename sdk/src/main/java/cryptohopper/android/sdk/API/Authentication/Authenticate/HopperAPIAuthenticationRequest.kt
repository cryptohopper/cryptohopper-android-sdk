//
//  HopperAPILoginRequest.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAuthenticationRequest : HopperAPIRequest<HopperAPIAuthenticationResponse> {

    constructor(
        username: String,
        password: String,
        verificationCode: String? = null,
        userAgent: String,
        appCheckToken: String?,
        deviceName: String?
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.setIsAuthenticationRequest(true)
        this.changeUrlPath("/oauth2/token")
        addBodyItem("grant_type", "password")
        addBodyItem("client_id", HopperAPIConfigurationManager.shared.config.clientId!!)
        addBodyItem("username", username)
        addBodyItem("password", password)
        addBodyItem("scope", "read,user,notifications,trade,manage")
        addBodyItem("version", "2.0")
        addBodyItem("platform", "Android")
        addHeader("User-Agent", userAgent)
        if (verificationCode != null) {
            addBodyItem("verification_code", (verificationCode))
        }
        if(appCheckToken != null){
            addHeader("X-Firebase-AppCheck",(appCheckToken?: ""))
        }
        if(deviceName != null){
            addBodyItem("deviceName", (deviceName?: ""))
        }
    }

}