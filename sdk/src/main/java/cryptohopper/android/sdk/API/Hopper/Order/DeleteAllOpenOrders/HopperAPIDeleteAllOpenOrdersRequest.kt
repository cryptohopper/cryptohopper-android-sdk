//
//  HopperAPIDeleteAllOpenOrdersRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIDeleteAllOpenOrdersRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order/all")
    }
    
}
