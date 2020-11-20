//
//  HopperEnabled.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import com.google.gson.annotations.SerializedName

enum class HopperEnabled(val rawValue: Int) {
    @SerializedName("enabled") ENABLED(1),
    @SerializedName("disabled") DISABLED(0)
}
