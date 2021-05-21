//
//  MarketReview.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarketReview (
    @SerializedName("id") val id: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("item_type") val itemType: String?,
    @SerializedName("reply_to") val replyTo: String?,
    @SerializedName("review_name") val reviewName: String?,
    @SerializedName("review") val review: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("created_date") val createdDate: String?,
    @SerializedName("updated_date") val updatedDate: String?,
    @SerializedName("replies") val replies: List<MarketReviewReply>?
)

data class MarketReviewReply (
        @SerializedName("id") val id: String?,
        @SerializedName("user_id") val userId: String?,
        @SerializedName("reply_to") val replyTo: String?,
        @SerializedName("review_name") val reviewName: String?,
        @SerializedName("review") val review: String?,
        @SerializedName("rating") val rating: String?,
        @SerializedName("created") val created: String?
)
