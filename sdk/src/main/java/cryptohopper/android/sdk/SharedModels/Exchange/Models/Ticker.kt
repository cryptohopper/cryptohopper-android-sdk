//
//  Ticker.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class Ticker (
    @SerializedName("currencyPair") val currencyPair: String?,
    @SerializedName("last") val last: String?,
    @SerializedName("lowestAsk") val lowestAsk: String?,
    @SerializedName("highestBid") val highestBid: String?,
    @SerializedName("percentChange") val percentChange: String?,
    @SerializedName("baseVolume") val baseVolume: String?,
    @SerializedName("quoteVolume") val quoteVolume: String?,
    @SerializedName("isFrozen") val isFrozen: Int?,
    @SerializedName("24hrHigh") val oneDayHigh: String?,
    @SerializedName("24hrLow") val oneDayLow: String?
)
