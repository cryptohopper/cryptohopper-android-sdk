//
//  HopperAPIGetOneSubscriptionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetOneUserSubscriptionRequest: HopperAPIRequest<HopperAPIGetOneUserSubscriptionResponse> {
    
    constructor(subscriptionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/subscription/$subscriptionId")
    }
    
}
