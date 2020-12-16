//
//  HopperAPIGetTradeHistoryResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.HopperTradeHistory

data class HopperAPIGetTradeHistoryResponse (
        @SerializedName("data") val data: HopperAPIGetTradeHistoryData?
)

data class HopperAPIGetTradeHistoryData (
        @SerializedName("trades") val trades: List<HopperTradeHistory>?
)