//
//  HopperAPIUpdateHopperRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateHopperRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String ,name : String?, enabled : Int?, apiConfig : HopperConfigAPIConfig? ) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId")
        if(name != null){
            addBodyItem( "name", name)
        }
        if(enabled != null){
            addBodyItem( "enabled", enabled)
        }
        if(apiConfig != null){
            addBodyItem( "api_config", apiConfig)
        }
    }
    
}
