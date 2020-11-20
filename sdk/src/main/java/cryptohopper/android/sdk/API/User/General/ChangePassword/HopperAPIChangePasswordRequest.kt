//
//  HopperAPIChangePasswordRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIChangePasswordRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(password : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user/password")
        addBodyItem( "password", password)
    }
    
}
