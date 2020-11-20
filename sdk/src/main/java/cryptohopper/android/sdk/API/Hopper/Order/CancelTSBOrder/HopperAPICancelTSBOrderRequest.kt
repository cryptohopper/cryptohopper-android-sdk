//
//  HopperAPICancelTSBOrderRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPICancelTSBOrderRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,orderId : Int ) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order/$orderId/tsb")
    }
    
}
