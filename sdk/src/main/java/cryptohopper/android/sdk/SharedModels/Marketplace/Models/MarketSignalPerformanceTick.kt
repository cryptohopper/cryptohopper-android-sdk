//
//  MarketSignalPerformance.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarketSignalPerformanceTick (
    @SerializedName("signal_time") val signalTime: Date?,
    @SerializedName("result_sum") val resultSum: Double?,
    @SerializedName("result_sum_perct") val resultSumPerct: Double?
)