//
//  HopperAPIMovePositionsToReservedRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIMoveMultiplePositionsToReservedRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionIds : List<Int> ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/movetoreserved")
        addBodyItem( "position_ids", positionIds)
    }
    
}

