//
//  HopperCommonMessageResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 27/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperCommonMessageResponse (
    @SerializedName("data") val data: String?,
    @SerializedName("status") val status: Int?,
    @SerializedName("error") val error: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("code") val code: Int?
)
