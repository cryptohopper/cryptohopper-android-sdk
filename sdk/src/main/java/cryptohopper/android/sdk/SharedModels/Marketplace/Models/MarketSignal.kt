//
//  MarketSignal.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class MarketSignal (
    @SerializedName("id") val id: String?,
    @SerializedName("signal_id") val signalId: String?,
    @SerializedName("performance") val performance: List<MarketSignalPerformanceTick>?,
    @SerializedName("plan_id") val planId: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("feature_image") val featureImage: String?,
    @SerializedName("subscription_fee_currency") val subscriptionFeeCurrency: String?,
    @SerializedName("subscription_fee") val subscription_fee: String?,
    @SerializedName("exchanges") val exchanges: String?,
    @SerializedName("performance_pct") val performancePct: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("total_votes") val totalVotes: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("last_10_signals") val lastTenSignals: List<Signal>?,
    @SerializedName("signal_details") val signalDetails: Map<String,String>?,
    @SerializedName("reviews") val reviews: MarketSignalReviewData?,
    @SerializedName("seller_id") val sellerId: String?,
    @SerializedName("seller_name") val sellerName: String?,
    @SerializedName("seller_logo") val sellerLogo: String?,
    @SerializedName("is_refundable") val isRefundable: Int?,
    @SerializedName("price_id") val priceId: String?,
    @SerializedName("total_subs") val totalSubs: String?,
    @SerializedName("total_reviews") val totalReviews: String?,
    @SerializedName("config") val config: Map<String,String>?
)

data class MarketSignalReviewData (
        @SerializedName("data") val data: List<MarketReview>?
)
