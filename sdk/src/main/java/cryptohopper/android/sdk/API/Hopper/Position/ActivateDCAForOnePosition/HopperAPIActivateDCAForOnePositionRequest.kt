//
//  HopperAPIActivateDCAForOnePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIActivateDCAForOnePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId : Int , marketOrder : Int ,trailingBuy : Int ,trailingBuyPercentage : Int ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/dca/$positionId")
        addBodyItem( "market_order", marketOrder)
        addBodyItem( "trailing_buy",  trailingBuy)
        addBodyItem( "trailing_buy_percentage",  trailingBuyPercentage)
    }

}
