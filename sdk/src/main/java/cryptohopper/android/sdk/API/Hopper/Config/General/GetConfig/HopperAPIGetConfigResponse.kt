//
//  HopperAPIGetConfigResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

import com.google.gson.annotations.SerializedName

data class HopperAPIGetConfigResponse (
        @SerializedName("data") val data: HopperConfig?
)
