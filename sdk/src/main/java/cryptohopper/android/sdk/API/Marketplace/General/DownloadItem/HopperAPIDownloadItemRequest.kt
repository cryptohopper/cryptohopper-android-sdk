//
//  HopperAPIDownloadItemRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIDownloadItemRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(marketPlaceItemId : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/downloaditem")
        this.addHeader("marketplace_item_id",  marketPlaceItemId)
    }
    
}
