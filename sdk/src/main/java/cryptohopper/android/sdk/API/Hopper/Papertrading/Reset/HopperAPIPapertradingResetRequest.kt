//
//  HopperAPIPapertradingResetRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIPapertradingResetRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(id : String) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$id/papertrading/reset")
    }
    
}
