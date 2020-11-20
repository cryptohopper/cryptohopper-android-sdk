//
//  HopperAPIGetSingleHoperRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetSingleHopperRequest: HopperAPIRequest<HopperAPIGetSingleHopperResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId")
    }
    
}
