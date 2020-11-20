//
//  HopperAPIGetPairOrderBookOfExchangeResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetPairOrderBookOfExchangeResponse (
        @SerializedName("data") val data: HopperAPIGetPairOrderBookOfExchangeData?
)

data class HopperAPIGetPairOrderBookOfExchangeData (
        @SerializedName("asks") val asks: List<List<Double>>?,
        @SerializedName("bids") val bids: List<List<Double>>?
)