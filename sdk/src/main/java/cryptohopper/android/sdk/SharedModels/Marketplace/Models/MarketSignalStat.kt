//
//  MarketSignalStat.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class MarketSignalStat (
    @SerializedName("weekly") val weekly: String?,
    @SerializedName("daily") val daily: String?,
    @SerializedName("total_signals_3_months") val totalSignals3Months: String?,
    @SerializedName("average_profit") val averageProfit: String?,
    @SerializedName("total_subscribers") val totalSubscribers: String?
)