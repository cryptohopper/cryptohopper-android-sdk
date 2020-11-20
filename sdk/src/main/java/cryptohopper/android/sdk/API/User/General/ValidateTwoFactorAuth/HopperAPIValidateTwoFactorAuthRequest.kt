//
//  HopperAPIValidateTwoFactorAuthRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIValidateTwoFactorAuthRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(code : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/user/validatetwofactor")
        addQueryItem( "code", code)
    }

}
