//
//  HopperAPIUpdateConfigRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateConfigRequest: HopperAPIRequest<HopperAPIUpdateConfigResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/config")
    }
    
}
