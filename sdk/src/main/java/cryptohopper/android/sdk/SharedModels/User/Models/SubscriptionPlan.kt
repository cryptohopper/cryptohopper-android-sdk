//
//  SubscriptionPlan.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName

data class SubscriptionPlan (
    @SerializedName("plan_id") val planId: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("price_month") val priceMonth: String?,
    @SerializedName("price_year") val priceYear: String?,
    @SerializedName("subscribed") val subscribed: String?
)