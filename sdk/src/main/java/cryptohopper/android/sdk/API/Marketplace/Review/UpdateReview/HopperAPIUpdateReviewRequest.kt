//
//  HopperAPIUpdateReviewRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateReviewRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(reviewId: Int,reviewName : String,review : String ,rating:Int) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/market/review/$reviewId")
        addBodyItem( "review_name", reviewName)
        addBodyItem( "review", review)
        addBodyItem( "rating", rating)
    }
    
}

