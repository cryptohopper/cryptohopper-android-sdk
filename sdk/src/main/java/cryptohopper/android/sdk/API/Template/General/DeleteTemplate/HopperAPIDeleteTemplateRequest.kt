//
//  HopperAPIDeleteTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIDeleteTemplateRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(templateId : Int) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/template/$templateId")
    }
    
}
