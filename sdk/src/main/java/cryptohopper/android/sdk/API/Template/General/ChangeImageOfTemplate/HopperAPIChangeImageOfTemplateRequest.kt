//
//  HopperAPIChangeImageOfTemplateRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIChangeImageOfTemplateRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(templateId : Int,image : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/template/$templateId/changeimage")
        addBodyItem( "image", image)
    }
    
}
