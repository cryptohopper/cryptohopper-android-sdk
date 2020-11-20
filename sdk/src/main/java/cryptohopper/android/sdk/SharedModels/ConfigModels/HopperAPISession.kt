

//
//  HopperSession.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import java.util.*

class HopperAPISession{

    var refreshToken:String? = null
    var accessToken:String? = null
    var accessTokenExpiresAt: Date? = null

    constructor(accessToken : String,refreshToken : String, accessTokenExpiresAt : Date)  {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
        this.accessTokenExpiresAt = accessTokenExpiresAt
    }

}