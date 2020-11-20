//
//  HopperAPILoginResponse.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIAuthenticationResponse (
        @SerializedName("access_token") val accessToken: String?
)