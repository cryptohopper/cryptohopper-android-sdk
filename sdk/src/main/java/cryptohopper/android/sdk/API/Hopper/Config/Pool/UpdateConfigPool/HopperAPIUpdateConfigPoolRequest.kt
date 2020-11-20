//
//  HopperAPIUpdateConfigPoolRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateConfigPoolRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,enabled : HopperEnabled ,configPool : HopperConfigPool) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/config/pool/" + configPool.id)
        addBodyItem( "pool_name", configPool.name ?: "")
        addBodyItem( "selected_coins", configPool.coins ?: "")
        addBodyItem( "config", configPool.config ?: "")
        addBodyItem( "enabled", enabled )
    }
    
}
