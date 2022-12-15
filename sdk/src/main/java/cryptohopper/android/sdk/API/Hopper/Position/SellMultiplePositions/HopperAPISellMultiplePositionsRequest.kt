//
//  HopperAPISellMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPISellMultiplePositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,positionIds : List<Int>, marketOrder : Boolean) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/sell")
        addBodyItem( "position_id", positionIds)
        if(marketOrder){
            addBodyItem("market_order", 1)
        }else{
            addBodyItem("market_order", 0)
        }
    }
    
}
