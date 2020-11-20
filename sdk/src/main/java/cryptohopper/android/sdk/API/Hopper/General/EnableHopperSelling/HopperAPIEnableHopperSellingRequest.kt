//
//  HopperAPIEnableHopperSellingRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIEnableHopperSellingRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String ) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/enable/selling")
    }
    
}
