//
//  HopperAPIGetHopperStatsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import cryptohopper.android.sdk.API.Hopper.Stats.GetStats.HopperAPIGetHopperStatsResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetHopperStatsRequest: HopperAPIRequest<HopperAPIGetHopperStatsResponse> {
    
    constructor(hopperId : String ) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/stats")
    }
    
}
