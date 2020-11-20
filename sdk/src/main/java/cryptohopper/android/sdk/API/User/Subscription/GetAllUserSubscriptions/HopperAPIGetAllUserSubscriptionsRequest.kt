//
//  HopperAPIGetAllSubscriptionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetAllUserSubscriptionsRequest: HopperAPIRequest<HopperAPIGetAllUserSubscriptionsResponse> {
    
    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/subscription")
    }
    
}
