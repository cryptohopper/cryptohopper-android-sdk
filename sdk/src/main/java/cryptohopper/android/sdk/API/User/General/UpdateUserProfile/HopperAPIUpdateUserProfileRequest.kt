//
//  HopperAPIUpdateUserProfileRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIUpdateUserProfileRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(name : String?, addressOne : String?,addressTwo : String?, city : String?,region : String?,country : String? , postalCode : String?,phone : String? ,website : String?) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath("/user")

        if(name != null && name != ""){
            addBodyItem( "name", name)
        }
        if(addressOne != null && addressOne != ""){
            addBodyItem( "address1", addressOne)
        }
        if(addressTwo != null && addressTwo != ""){
            addBodyItem( "address2", addressTwo)
        }
        if(city != null && city != ""){
            addBodyItem( "city", city)
        }
        if(region != null && region != ""){
            addBodyItem( "region", region)
        }
        if(country != null && country != ""){
            addBodyItem( "country", country)
        }
        if(postalCode != null && postalCode != ""){
            addBodyItem( "postalCode", postalCode)
        }
        if(phone != null && phone != ""){
            addBodyItem( "phone", phone)
        }
        if(website != null && website != ""){
            addBodyItem( "website", website)
        }

    }

}
