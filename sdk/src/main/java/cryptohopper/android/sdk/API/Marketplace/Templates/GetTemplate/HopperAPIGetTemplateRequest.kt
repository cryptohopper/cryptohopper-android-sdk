//
//  HopperAPIGetTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTemplateRequest: HopperAPIRequest<HopperAPIGetTemplateResponse> {
    
    constructor(templateId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/templates/$templateId")
    }
    
}
