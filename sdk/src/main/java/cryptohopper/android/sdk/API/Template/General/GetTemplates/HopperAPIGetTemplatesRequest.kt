//
//  HopperAPIGetTemplatesRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetTemplatesRequest: HopperAPIRequest<HopperAPIGetTemplatesResponse> {
    
    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/template")
    }
    
}
