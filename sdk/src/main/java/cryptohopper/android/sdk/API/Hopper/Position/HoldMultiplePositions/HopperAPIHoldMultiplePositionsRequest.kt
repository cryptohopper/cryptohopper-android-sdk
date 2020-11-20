//
//  HopperAPIHoldMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIHoldMultiplePositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionIds : List<Int>) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/hold")
        addBodyItem( "position_id", positionIds)
    }
    
}
