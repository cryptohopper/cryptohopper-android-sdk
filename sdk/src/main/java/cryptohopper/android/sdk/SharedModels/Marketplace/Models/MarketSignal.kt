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
    @SerializedName("link") val signalDetails: Map<String,String>?,
    @SerializedName("link") val reviews: MarketSignalReviewData?,
    @SerializedName("link") val sellerId: String?,
    @SerializedName("link") val sellerName: String?,
    @SerializedName("link") val sellerLogo: String?,
    @SerializedName("link") val isRefundable: Int?
)

data class MarketSignalReviewData (
        @SerializedName("data") val data: List<MarketReview>?
)
