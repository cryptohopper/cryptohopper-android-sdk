//
//  MarketItem.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class MarketItem (
    @SerializedName("id") val id: String?,
    @SerializedName("item_type") val itemType: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("total_votes") val totalVotes: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("sales") val sales: Int?,
    @SerializedName("price") val price: String?,
    @SerializedName("avg_profit_trade") val averageProfitPerTrade: String?
)