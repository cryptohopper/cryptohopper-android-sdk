//
//  HopperAPIEnablePushNotificationRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIEnablePushNotificationRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(enableAll : Boolean = false, permissions : List<PushNotificationPermissions>) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user")
        if(!enableAll){
            val values : List<String> = permissions.map { per -> per.rawValue }
            val permissionsStr = values.joinToString(separator = ",")
            addBodyItem( "permissions", permissionsStr)
        }
        
    }
    
}
