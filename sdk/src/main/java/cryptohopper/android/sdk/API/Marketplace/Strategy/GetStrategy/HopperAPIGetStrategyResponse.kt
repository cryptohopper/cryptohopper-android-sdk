//
//  HopperAPIGetStrategyResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetStrategyResponse (
        @SerializedName("data") val data: MarketStrategy?
)
