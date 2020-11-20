//
//  HopperCommonMessageResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperCommonMessageResponse (
    @SerializedName("data") val data: String?
)
