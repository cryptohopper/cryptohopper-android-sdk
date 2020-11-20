//
//  HopperAPIGetCandlesFromExchangeRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod
import java.util.*

class HopperAPIGetCandlesFromExchangeRequest: HopperAPIRequest<HopperAPIGetCandlesFromExchangeResponse> {
    
    constructor(exchange : String, pair : String, timeFrame: CandleTimeFrame, startDate : Date, endDate : Date) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/candle/$pair/" + timeFrame.rawValue + "/" + startDate.time + "/" + endDate.time)
    }

}
