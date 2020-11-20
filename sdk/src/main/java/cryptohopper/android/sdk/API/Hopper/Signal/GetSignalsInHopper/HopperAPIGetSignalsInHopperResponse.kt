//
//  HopperAPIGetSignalsInHopperResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetSignalsInHopperResponse (
        @SerializedName("data") val data: HopperAPIGetSignalsInHopperData?
)

data class HopperAPIGetSignalsInHopperData (
        @SerializedName("signals") val signals: List<MarketSignal>?
)
