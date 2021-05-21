//
//  MarketplaceTemplate.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarketplaceTemplate (
    @SerializedName("id") val id: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("feature_image") val featureImage: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("total_votes") val totalVotes: String?,
    @SerializedName("sales") val sales: String?,
    @SerializedName("price_id") val priceId: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("base_currency") val baseCurrency: String?,
    @SerializedName("version") val version: String?,
    @SerializedName("updated") val updated: String?,
    @SerializedName("update_info") val updateInfo: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("hidden_configuration") val hiddenConfiguration: List<String>?,
    @SerializedName("allowed_coins") val allowedCoins: List<String>?,
    @SerializedName("reviews") val reviews: MarketplaceTemplateReviewData?,
    @SerializedName("price") val price: String?,
    @SerializedName("price_currency") val priceCurrency: String?,
    @SerializedName("dependent_strategies") val dependentStrategies: List<MarketStrategy>?,
    @SerializedName("seller_id") val sellerId: String?,
    @SerializedName("seller_name") val sellerName: String?,
    @SerializedName("seller_logo") val sellerLogo: String?
)


