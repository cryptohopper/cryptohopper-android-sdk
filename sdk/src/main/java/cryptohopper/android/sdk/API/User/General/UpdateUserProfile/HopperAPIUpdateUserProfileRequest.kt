//
//  HopperAPIUpdateUserProfileRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateUserProfileRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(name : String, addressOne : String,addressTwo : String, city : String,region : String,country : String , postalCode : String,phone : String ,website : String) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/user")
        addBodyItem( "name", name)
        addBodyItem( "address1", addressOne)
        addBodyItem( "address2", addressTwo)
        addBodyItem( "city", city)
        addBodyItem( "region", region)
        addBodyItem( "country", country)
        addBodyItem( "postalCode", postalCode)
        addBodyItem( "phone", phone)
        addBodyItem( "website", website)
    }

}
