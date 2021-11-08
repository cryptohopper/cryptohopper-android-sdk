//
//  HopperAPIUpdateSignalConfigRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateSignalConfigRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,signalId : Int,config : Map<String,Any>) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/signal/$signalId")
        var arr = mutableMapOf<String,Any>()
        for ((k, v) in config) {
            arr[k] = v
        }
        addBodyItem("config",arr)
    }
    
}
