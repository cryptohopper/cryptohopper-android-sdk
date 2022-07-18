//
//  HopperAPIEnableHopperPanicRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIEnableHopperPanicRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String, useMarketOrder : Boolean ) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/panicbutton")

        if(useMarketOrder){
            this.addQueryItem("market_orders","1")
        }
    }

}
