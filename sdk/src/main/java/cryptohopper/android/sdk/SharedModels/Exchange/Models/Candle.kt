//
//  Candle.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class Candle(
    @SerializedName("date") val date: Date?,
    @SerializedName("high") val high: Double?,
    @SerializedName("low") val low: Double?,
    @SerializedName("open") val open: Double?,
    @SerializedName("close") val close: Double?,
    @SerializedName("volume") val volume: Double?,
    @SerializedName("quoteVolume") val quoteVolume: Double?
)
