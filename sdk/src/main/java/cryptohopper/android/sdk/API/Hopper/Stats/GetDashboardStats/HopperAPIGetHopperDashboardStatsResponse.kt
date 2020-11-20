//
//  HopperAPIGetHopperDashboardStatsResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetHopperDashboardStatsResponse (
        @SerializedName("data") val stats: HopperDashboardStats?
)