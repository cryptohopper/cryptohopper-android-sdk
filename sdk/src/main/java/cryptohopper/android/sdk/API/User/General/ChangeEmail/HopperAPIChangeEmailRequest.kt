//
//  HopperAPIChangeEmailRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIChangeEmailRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(email : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user/email")
        addBodyItem( "email", email)
    }
    
}
