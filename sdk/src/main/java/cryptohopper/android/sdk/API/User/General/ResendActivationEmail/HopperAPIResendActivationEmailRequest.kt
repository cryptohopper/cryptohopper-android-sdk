//
//  HopperAPIResendActivationEmailRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIResendActivationEmailRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(email : String,username : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user/resendactivation")
        addHeader("email", email)
        addHeader("username", username)
    }
    
}
