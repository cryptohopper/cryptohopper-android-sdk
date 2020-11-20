//
//  HopperAPIPapertradingWithdrawRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIPapertradingWithdrawRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(id : String,coin : String,amount : Double ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$id/papertrading/withdraw")
        addBodyItem( "coin", coin)
        addBodyItem( "amount", amount)
    }
    
}
