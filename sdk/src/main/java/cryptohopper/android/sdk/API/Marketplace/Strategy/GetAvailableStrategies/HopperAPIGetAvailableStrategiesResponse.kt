//
//  HopperAPIGetAvailableStrategiesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetAvailableStrategiesResponse (
        @SerializedName("data") val data: HopperAPIGetAvailableStrategiesData?
)

data class HopperAPIGetAvailableStrategiesData (
        @SerializedName("strategy") val strategy: List<MarketStrategy>?
)