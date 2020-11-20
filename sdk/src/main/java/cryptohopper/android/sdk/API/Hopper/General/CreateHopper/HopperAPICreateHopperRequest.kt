//
//  HopperAPICreateHopperRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 26/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPICreateHopperRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(name : String, enabled : Int?, templateId : Int?, apiConfig : HopperConfigAPIConfig?, config : HopperConfig? ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper")
        addBodyItem( "name", name)
        if(enabled != null){
            addBodyItem( "enabled", enabled)
        }
        if(templateId != null){
            addBodyItem( "template_id", templateId)
        }
        if(apiConfig != null){
            addBodyItem( "api_config", apiConfig)
        }
        if(config != null){
            addBodyItem( "config", config)
        }
    }
    
}
