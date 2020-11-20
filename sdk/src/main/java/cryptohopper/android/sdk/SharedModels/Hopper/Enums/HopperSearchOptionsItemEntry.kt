//
//  HopperSearchOptionsItemEntry.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//


import com.google.gson.annotations.SerializedName

enum class HopperSearchOptionsItemEntry(val rawValue: String) {
    @SerializedName("error") ERROR("error"),
    @SerializedName("info") INFO("info")
}