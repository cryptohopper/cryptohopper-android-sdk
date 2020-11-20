//
//  HopperAPILoadMarketTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPILoadMarketTemplateRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(templateId : Int,hopperId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/template/market/$templateId/load/$hopperId")
    }
    
}
