//
//  HopperAPIUpdateStrategyRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateStrategyRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(strategyId : Int,name : String,description : String,image : String,minBuys : Int,minSells : Int) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/strategy/$strategyId")
        addBodyItem( "name", name)
        addBodyItem( "description",  description)
        addBodyItem( "image",  image)
        addBodyItem( "min_buys",  minBuys)
        addBodyItem( "min_sells",  minSells)
    }
    
}
