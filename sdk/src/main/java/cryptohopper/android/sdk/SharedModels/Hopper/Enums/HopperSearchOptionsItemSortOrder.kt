//
//  HopperSearchOptionsItemSortOrder.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

enum class HopperSearchOptionsItemSortOrder(val rawValue: String) {
    @SerializedName("asc") ASCENDING("asc"),
    @SerializedName("desc") DESCENDING("desc")
}
