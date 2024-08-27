//
//  HopperAPISplitOnePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPISplitOnePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String,positionId : Int, percentage : String? = "") {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        if (percentage != null) {
            addBodyItem( "percentage",  percentage)
        }
        this.changeUrlPath("/hopper/$hopperId/position/split/$positionId")
    }

}

