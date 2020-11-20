//
//  HopperAPIReassignSubsriptionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIReassignSubsriptionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/subscription/remap")
    }
    
}
