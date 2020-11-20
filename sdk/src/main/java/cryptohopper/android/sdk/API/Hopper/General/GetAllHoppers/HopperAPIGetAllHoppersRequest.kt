//
//  HopperAPIGetAllHopersRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetAllHoppersRequest: HopperAPIRequest<HopperAPIGetAllHoppersResponse> {
    
    constructor(name : String?, exchange : HopperConfigExchange? , enabled : Int?) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper")
        if(name != null){
            addQueryItem( "name", name)
        }
        if(exchange != null){
            addQueryItem( "exchange", exchange.rawValue)
        }
        if(enabled != null){
            addQueryItem( "enabled", enabled.toString())
        }
    }
    
}
