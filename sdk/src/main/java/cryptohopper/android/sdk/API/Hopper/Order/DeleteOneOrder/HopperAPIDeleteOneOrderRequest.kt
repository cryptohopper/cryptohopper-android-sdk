//
//  HopperAPIDeleteOneOrderRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIDeleteOneOrderRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,orderId : Int) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order/$orderId")
    }
    
}
