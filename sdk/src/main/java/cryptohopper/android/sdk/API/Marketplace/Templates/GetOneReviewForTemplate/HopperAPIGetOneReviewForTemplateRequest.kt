//
//  HopperAPIGetOneReviewForTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetOneReviewForTemplateRequest: HopperAPIRequest<HopperAPIGetOneReviewForTemplateResponse> {
    
    constructor(templateId : Int,reviewId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/templates/$templateId/review/$reviewId")
    }
    
}
