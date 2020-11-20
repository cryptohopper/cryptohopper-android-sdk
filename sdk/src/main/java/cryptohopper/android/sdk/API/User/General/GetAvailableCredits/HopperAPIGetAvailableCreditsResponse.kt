//
//  HopperAPIGetAvailableCreditsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAvailableCreditsResponse (
        @SerializedName("data") val credit: Int?
)

