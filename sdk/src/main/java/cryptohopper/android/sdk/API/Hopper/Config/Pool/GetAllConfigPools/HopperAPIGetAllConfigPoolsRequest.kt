//
//  HopperAPIGetAllConfigPoolsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetAllConfigPoolsRequest: HopperAPIRequest<HopperAPIGetAllConfigPoolsResponse> {
    
    constructor(hopperId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/config/pool")
    }

}
