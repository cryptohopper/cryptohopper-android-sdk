//
//  Signal.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import java.util.*
import com.google.gson.annotations.SerializedName

data class Signal (
    @SerializedName("name") val name: String?,
    @SerializedName("collect_currency") val collectCurrency: String?,
    @SerializedName("signal_time") val signalTime: Date?,
    @SerializedName("signal_type") val signalType: String?,
    @SerializedName("coin") val coin: String?
)