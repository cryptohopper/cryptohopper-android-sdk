//
//  HopperAPIGetTradingPairOfExchangeRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTradingPairOfExchangeRequest: HopperAPIRequest<HopperAPIGetTradingPairOfExchangeResponse> {
    
    constructor(exchange : String, currency : String , baseCurrency : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/getmarket")
        addQueryItem("currency", currency)
        addQueryItem( "base_currency", baseCurrency)
    }
    
}
