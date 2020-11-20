//
//  HopperAPIUpdateSignalConfigRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateSignalConfigRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,signalId : Int) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/signal/$signalId")
    }
    
}
