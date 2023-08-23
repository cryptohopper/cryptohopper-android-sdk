//
//  HopperAPIRegisterUserRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import cryptohopper.android.sdk.API.User.General.RegisterUser.HopperAPIRegisterUserResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIRegisterUserRequest: HopperAPIRequest<HopperAPIRegisterUserResponse> {

    constructor(
        name : String,
        email : String,
        username : String,
        subscribe : Boolean,
        password : String,
        userAgent: String,
        appCheckToken: String?
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.changeUrlPath("/user/register")
        addHeader("name", name)
        addHeader("email",  email)
        addHeader("username",  username)
        addHeader("subscribe",  subscribe.toString())
        addHeader("password",  password)
        addHeader( "User-Agent",  userAgent)

        if(appCheckToken != null){
            addHeader("X-Firebase-AppCheck",(appCheckToken?: ""))
        }
    }

}
