//
//  HopperAPIDeleteStrategyRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIDeleteStrategyRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(strategyId : Int) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/strategy/$strategyId")
    }
    
}
