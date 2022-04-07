//
//  HopperAPIUpdatePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdatePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId:Int, values : MutableMap<String,Any>) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/setpositionsetting")

        addBodyItem( "position_ids", listOf<Int>(positionId))

        addBodyItem( "setting", values)
    }
    
}
