//
//  HopperAPIUpdateConfigRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateConfigRequest: HopperAPIRequest<HopperAPIUpdateConfigResponse> {
    
    constructor(hopperId : String,config : Map<String,Any> ) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/config")

        var arr = mutableMapOf<String,Any>()
        for ((k, v) in config) {
            arr[k] = v
        }
        addBodyItem("config",arr)
    }
    
}
