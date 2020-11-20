//
//  HopperAPIPostStrategyReviewRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIPostStrategyReviewRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(strategyId: Int,reviewName : String,review : String ,rating:Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/market/strategies/$strategyId/review")
        addBodyItem( "review_name", reviewName)
        addBodyItem( "review", review)
        addBodyItem( "rating", rating)
    }
    
}
