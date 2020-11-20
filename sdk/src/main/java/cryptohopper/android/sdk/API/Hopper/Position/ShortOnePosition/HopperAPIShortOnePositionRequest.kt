//
//  HopperAPIShortOnePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIShortOnePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId : Int ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/short/$positionId")
    }
    
}
