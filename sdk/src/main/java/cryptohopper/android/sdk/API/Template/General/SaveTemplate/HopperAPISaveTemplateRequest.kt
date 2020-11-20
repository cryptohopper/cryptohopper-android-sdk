//
//  HopperAPISaveTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPISaveTemplateRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : Int,saveAs : Int,name : String,description : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/template/save")
        addBodyItem( "save_as", saveAs)
        addBodyItem( "name", name)
        addBodyItem( "description", description)
    }
    
}
