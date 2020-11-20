//
//  HopperAPIGetOneSubscriptionPlanRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetOneSubscriptionPlanRequest: HopperAPIRequest<HopperAPIGetOneSubscriptionPlanResponse> {
    
    constructor(planId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/subscription/plans/$planId")
    }
    
}
