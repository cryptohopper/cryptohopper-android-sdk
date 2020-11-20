//
//  HopperAPIRemoveMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIRemoveMultiplePositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionIds : List<Int>) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/remove")
        addBodyItem( "position_id", positionIds)
    }
    
}
