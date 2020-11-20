//
//  HopperAPIUpdateConfigResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//


import com.google.gson.annotations.SerializedName

data class HopperAPIUpdateConfigResponse (
        @SerializedName("data") val data: HopperAPIUpdateConfigData?
)

data class HopperAPIUpdateConfigData (
        @SerializedName("config") val hoppers: HopperConfig?
)
