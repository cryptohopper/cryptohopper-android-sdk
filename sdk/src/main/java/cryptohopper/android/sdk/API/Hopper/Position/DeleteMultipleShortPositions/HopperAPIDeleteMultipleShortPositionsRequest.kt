//
//  HopperAPIDeleteMultipleShortPositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIDeleteMultipleShortPositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionIds : List<Int>) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/short/remove")
        addBodyItem( "position_ids", positionIds)
    }
    
}
