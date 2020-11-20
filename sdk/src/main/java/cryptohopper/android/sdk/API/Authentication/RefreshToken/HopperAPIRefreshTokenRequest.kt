//
//  HopperAPIRefreshTokenRequest.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 22/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIRefreshTokenRequest: HopperAPIRequest<HopperAPIAuthenticationResponse> {
    
    constructor(refreshToken:String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.changeUrlPath("/oauth2/refreshToken")
        addBodyItem( "refreshToken", refreshToken)
    }
    
}
