//
//  HopperAPIGetStrategiesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetStrategiesResponse (
        @SerializedName("data") val data: HopperAPIGetStrategiesData?
)

data class HopperAPIGetStrategiesData (
        @SerializedName("strategies") val strategies: List<Strategy>?
)


