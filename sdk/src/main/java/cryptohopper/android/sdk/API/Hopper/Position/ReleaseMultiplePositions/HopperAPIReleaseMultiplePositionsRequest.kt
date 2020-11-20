//
//  HopperAPIReleaseMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIReleaseMultiplePositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionIds : List<Int>) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/release")
        addBodyItem( "position_id", positionIds)
    }
    
}
