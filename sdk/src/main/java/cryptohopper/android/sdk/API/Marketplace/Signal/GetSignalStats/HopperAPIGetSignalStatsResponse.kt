//
//  HopperAPIGetSignalStatsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetSignalStatsResponse (
        @SerializedName("data") val data: MarketSignalStat?
)