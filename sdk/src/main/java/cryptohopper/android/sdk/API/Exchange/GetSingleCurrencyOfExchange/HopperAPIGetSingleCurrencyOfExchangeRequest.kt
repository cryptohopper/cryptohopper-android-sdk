//
//  HopperAPIGetSingleCurrencyOfExchangeRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetSingleCurrencyOfExchangeRequest: HopperAPIRequest<HopperAPIGetSingleCurrencyOfExchangeResponse> {
    
    constructor(exchange : String,coin : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/currency")
        addQueryItem("coin", coin)
    }

}
