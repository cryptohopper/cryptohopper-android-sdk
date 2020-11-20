//
//  HopperAPIDeleteMultipleOrdersRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIDeleteMultipleOrdersRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,orderIds : List<Int>) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order")
        addBodyItem( "order_ids",  orderIds)
    }
    
}
