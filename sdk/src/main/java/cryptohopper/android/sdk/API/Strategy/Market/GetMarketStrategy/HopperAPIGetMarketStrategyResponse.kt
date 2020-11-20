//
//  HopperAPIGetMarketStrategyResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetMarketStrategyResponse (
        @SerializedName("data") val data: Strategy?
)

