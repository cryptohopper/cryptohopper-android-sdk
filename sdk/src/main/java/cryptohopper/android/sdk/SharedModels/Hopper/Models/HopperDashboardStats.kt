//
//  HopperGeneralStats.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 28/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperDashboardStats (
    @SerializedName("total_invest") val totalInvested: String?,
    @SerializedName("total_returns") val totalReturns: String?,
    @SerializedName("total_positions") val totalPositions: String?,
    @SerializedName("total_fees") val totalFees: String?
)
