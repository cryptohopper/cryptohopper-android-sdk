//
//  HopperAPIGetOneReviewResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetOneReviewResponse (
        @SerializedName("data") val data: MarketReview?
)