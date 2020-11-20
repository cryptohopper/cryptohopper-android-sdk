//
//  HopperAPIGetPrecisionForCurrencyOfExchangeRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetPrecisionForCurrencyOfExchangeRequest: HopperAPIRequest<HopperAPIGetPrecisionForCurrencyOfExchangeResponse> {
    
    constructor(exchange : String, currency : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/currency/$currency/decimals")
    }
    
}
