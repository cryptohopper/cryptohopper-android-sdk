//
//  HopperAPIPapertradingDepositRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIPapertradingDepositRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(id : String,coin : String,amount : Double ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$id/papertrading/deposit")
        addBodyItem( "coin", coin)
        addBodyItem( "amount", amount)
    }
    
}
