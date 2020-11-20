//
//  HopperAPIGetMarketStrategiesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetMarketStrategiesResponse (
        @SerializedName("data") val data: HopperAPIGetMarketStrategiesData?
)

data class HopperAPIGetMarketStrategiesData (
        @SerializedName("strategies") val strategies: List<Strategy>?
)


