//
//  HopperAPIHopperMostTradedCurrencyResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//


import com.google.gson.annotations.SerializedName

data class HopperAPIHopperMostTradedCurrencyResponse (
        @SerializedName("data") val data: List<HopperMostTradedModel>?
)

data class HopperMostTradedModel (
        @SerializedName("tradeAmount") val tradeAmount: String?,
        @SerializedName("currency") val currency: String?,
        @SerializedName("profit") val profit: String?,
        @SerializedName("averageHoldingTimeInHours") val averageHoldingTimeInHours: String?
)


