//
//  HopperAPIGetSignalByIdRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetSignalByIdRequest: HopperAPIRequest<HopperAPIGetSignalByIdResponse> {
    
    constructor(hopperId : String,signalId: Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/signal/$signalId")
    }
    
}
