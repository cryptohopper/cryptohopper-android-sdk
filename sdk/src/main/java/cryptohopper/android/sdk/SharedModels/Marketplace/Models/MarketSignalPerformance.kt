//
//  MarketSignalPerformanceA.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class MarketSignalPerformance (
    @SerializedName("id") val id: String?,
    @SerializedName("signal_id") val signalId: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("base_currency") val baseCurrency: Int?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("market") val market: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("signal_rate") val signalRate: String?,
    @SerializedName("signal_type") val signalType: String?,
    @SerializedName("signal_config") val signalConfig: Map<String,String>?,
    @SerializedName("result_5min") val result5min: String?,
    @SerializedName("result_15min") val result15min: String?,
    @SerializedName("result_1hour") val result_1hour: String?,
    @SerializedName("result_3day") val result3hour: String?,
    @SerializedName("result_6hour") val result6hour: String?,
    @SerializedName("result_12hour") val result12hour: String?,
    @SerializedName("result_1day") val result1day: String?,
    @SerializedName("result_3day") val result3day: String?,
    @SerializedName("result_1week") val result1week: String?,
    @SerializedName("result_1month") val result1month: String?,
    @SerializedName("result_highest") val resultHighest: String?,
    @SerializedName("result_lowest") val resultLowest: String?
)

