//
//  BasicTemplate.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class BasicTemplate (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("base_currency") val baseCurrency: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("coins") val coins: String?,
    @SerializedName("bot_type") val botType: String?,
    @SerializedName("config") val config: HopperConfig?,
    @SerializedName("config_pools") val configPools: List<HopperConfigPool>?,
    @SerializedName("signals") val signals: List<MarketSignal>?,
    @SerializedName("triggers") val triggers: List<String>?
)

