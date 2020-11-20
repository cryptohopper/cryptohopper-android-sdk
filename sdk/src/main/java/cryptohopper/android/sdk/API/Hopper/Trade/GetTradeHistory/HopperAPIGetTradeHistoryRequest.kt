//
//  HopperAPIGetTradeHistoryRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTradeHistoryRequest: HopperAPIRequest<HopperAPIGetTradeHistoryResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/trade")
    }
    
}
