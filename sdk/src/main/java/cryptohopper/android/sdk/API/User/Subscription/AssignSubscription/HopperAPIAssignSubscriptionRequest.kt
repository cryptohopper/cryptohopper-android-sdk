//
//  HopperAPIAssignSubscriptionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAssignSubscriptionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : Int,subscriptionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/subscription/assign")
        addBodyItem( "hopper_id", hopperId)
        addBodyItem( "subscription_id", subscriptionId)
    }

}
