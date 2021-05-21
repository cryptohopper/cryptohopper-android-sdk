//
//  Strategy.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class Strategy (
    @SerializedName("id") val id: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("created_date") val createdDate: String?,
    @SerializedName("market_id") val marketId: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("hidden_configuration") val hiddenConfiguration: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("total_votes") val totalVotes: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("sales") val sales: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("price_currency") val priceCurrency: String?
)
