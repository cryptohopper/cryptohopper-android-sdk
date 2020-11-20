//
//  HopperAPIGetOneOpenOrderRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetOneOpenOrderRequest: HopperAPIRequest<HopperAPIGetOneOpenOrderResponse> {
    
    constructor(hopperId : String,orderId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order/$orderId")
    }

}

