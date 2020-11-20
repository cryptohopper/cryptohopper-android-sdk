//
//  HopperAPIChangeHopperImageRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIChangeHopperImageRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String ,image : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/changeimage")
        addBodyItem( "image", image)
    }
    
}
