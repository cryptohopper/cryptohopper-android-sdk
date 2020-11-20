//
//  HopperAPIGetLastSignalRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetLastSignalRequest: HopperAPIRequest<HopperAPIGetLastSignalResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/signal/last")
    }
    
}
