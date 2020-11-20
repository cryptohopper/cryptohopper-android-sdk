//
//  HopperAPIActivateDCAForMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIActivateDCAForMultiplePositionsRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionIds : List<Int> , marketOrder : Int ,trailingBuy : Int ,trailingBuyPercentage : Int ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/dca")
        addBodyItem( "position_ids", positionIds)
        addBodyItem( "market_order", marketOrder)
        addBodyItem( "trailing_buy", trailingBuy)
        addBodyItem( "trailing_buy_percentage", trailingBuyPercentage)
    }

}

