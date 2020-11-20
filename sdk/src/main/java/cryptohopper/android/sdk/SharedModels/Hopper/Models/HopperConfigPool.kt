//
//  HopperConfigPool.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperConfigPool (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("coins") val coins: List<String>?,
    @SerializedName("config") val config: HopperConfig?,
    @SerializedName("updated") val updated: String?,
    @SerializedName("status") val status: String?
)
