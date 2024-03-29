//
//  HopperAPIGetAvailableSignalsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetAvailableSignalsRequest: HopperAPIRequest<HopperAPIGetAvailableSignalsResponse> {
    
    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/signals")
        addQueryItem("available_in_app","1")
    }
    
}
