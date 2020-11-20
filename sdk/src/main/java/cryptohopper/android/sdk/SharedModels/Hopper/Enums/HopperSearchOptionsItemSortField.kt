//
//  HopperSearchOptionsItemSort.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

enum class HopperSearchOptionsItemSortField(val rawValue: String) {
    @SerializedName("entry_date") ENTRY_DATE("entry_date"),
    @SerializedName("entry_type") ENTRY_TYPE("entry_type")
}