//
//  HopperAPIDeleteReviewRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIDeleteReviewRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(reviewId: Int) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/market/review/$reviewId")
    }
    
}

