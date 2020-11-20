//
//  MarketReview.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class MarketReview (
    @SerializedName("id") val id: Int?,
    @SerializedName("item_id") val itemId: Int?,
    @SerializedName("item_type") val itemType: String?,
    @SerializedName("reply_to") val replyTo: String?,
    @SerializedName("review_name") val reviewName: String?,
    @SerializedName("review") val review: String?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("created_date") val createdDate: Date?,
    @SerializedName("updated_date") val updatedDate: Date?
)