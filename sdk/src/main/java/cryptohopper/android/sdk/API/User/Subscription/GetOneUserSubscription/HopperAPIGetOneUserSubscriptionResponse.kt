//
//  HopperAPIGetOneSubscriptionResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetOneUserSubscriptionResponse (
        @SerializedName("data") val data: UserSubscription?
)