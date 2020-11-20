//
//  HopperAPIGetExchangeTickerPairRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetExchangeTickerPairRequest: HopperAPIRequest<HopperAPIGetExchangeTickerPairResponse> {
    
    constructor(exchange : String,pair : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/ticker/$pair")
    }
    
}
