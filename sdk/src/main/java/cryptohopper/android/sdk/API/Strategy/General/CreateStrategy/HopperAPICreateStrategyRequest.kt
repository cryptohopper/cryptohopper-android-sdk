//
//  HopperAPICrateStrategyRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPICrateStrategyRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(strategyId : Int,name : String,description : String,image : String,minBuys : Int,minSells : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/strategy")
        addBodyItem( "strategy_id", strategyId)
        addBodyItem( "name", name)
        addBodyItem( "description", description)
        addBodyItem( "image", image)
        addBodyItem( "min_buys", minBuys)
        addBodyItem( "min_sells", minSells)
    }
    
}
