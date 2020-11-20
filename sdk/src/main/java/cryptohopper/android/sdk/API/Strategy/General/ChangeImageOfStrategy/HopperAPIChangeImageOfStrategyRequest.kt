//
//  HopperAPIChangeImageOfStrategyRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIChangeImageOfStrategyRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(strategyId : Int,image: String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/strategy/$strategyId")
        addBodyItem( "image", image)
    }
    
}
