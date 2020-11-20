//
//  HopperAPIGetMarketTemplatesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetMarketTemplatesResponse (
        @SerializedName("data") val data: HopperAPIGetMarketTemplatesData?
)

data class HopperAPIGetMarketTemplatesData (
        @SerializedName("templates") val templates: List<MarketTemplate>?
)