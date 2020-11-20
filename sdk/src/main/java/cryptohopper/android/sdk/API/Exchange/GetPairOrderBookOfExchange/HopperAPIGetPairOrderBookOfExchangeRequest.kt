//
//  HopperAPIGetPairOrderBookOfExchangeRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetPairOrderBookOfExchangeRequest: HopperAPIRequest<HopperAPIGetPairOrderBookOfExchangeResponse> {
    
    constructor(exchange : String,pair : String,depth : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/$pair/orderbook/$depth")
    }
    
}
