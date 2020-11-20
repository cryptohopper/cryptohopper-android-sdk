//
//  UserSubscription.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserSubscription (
    @SerializedName("subscription_id") val subscriptionId: String?,
    @SerializedName("plan_id") val planId: String?,
    @SerializedName("payment_term") val paymentTerm: String?,
    @SerializedName("payment_method_id") val paymentMethodId: String?,
    @SerializedName("start_time") val startTime: String?,
    @SerializedName("end_time") val endTime: String?,
    @SerializedName("subscription_status") val subscriptionStatus: String?,
    @SerializedName("auto_renewal") val autoRenewal: String?,
    @SerializedName("plan_name") val planName: String?,
    @SerializedName("plan_description") val planDescription: String?
)