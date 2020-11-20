//
//  CandleTimeFrame.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

enum class CandleTimeFrame(val rawValue: String) {
    @SerializedName("5m") FIVE_MIN("5m"),
    @SerializedName("15m") FIFTEEN_MIN("15m"),
    @SerializedName("30m") THIRTY_MIN("30m"),
    @SerializedName("1h") ONE_HOUR("1h"),
    @SerializedName("2h") TWO_HOURS("2h"),
    @SerializedName("4h") FOUR_HOURS("4h"),
    @SerializedName("1d") ONE_DAY("1d")
}
