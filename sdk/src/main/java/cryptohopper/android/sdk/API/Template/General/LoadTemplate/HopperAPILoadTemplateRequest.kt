//
//  HopperAPILoadTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPILoadTemplateRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(templateId : Int,hopperId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/template/$templateId/load/$hopperId")
    }
    
}
