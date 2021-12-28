//
//  HopperAPIGetTradeHistoryRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod
import java.util.*

class HopperAPIGetTradeHistoryRequest: HopperAPIRequest<HopperAPIGetTradeHistoryResponse> {
    
    constructor(hopperId : String, dateFrom : String?, count : Int?) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/trade")
        if(dateFrom != null){
            this.addQueryItem( "dateFrom", dateFrom)
        }
        if(count != null){
            this.addQueryItem( "count", count.toString())
        }
    }
}
