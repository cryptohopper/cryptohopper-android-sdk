//
//  HopperAPIUpdateMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateShortPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , shortId:Int, values: MutableMap<String,Any>) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/setshortsetting")

        addBodyItem( "position_ids", listOf<Int>(shortId))

        addBodyItem("setting", values)
    }
    
}
