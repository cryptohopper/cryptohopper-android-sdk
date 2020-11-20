//
//  HopperAPISellOnePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPISellOnePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionId : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/sell/$positionId")
    }
    
}
