

//
//  cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIApplication.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIApplication(
        @SerializedName("id") val id: String?,
        @SerializedName("name") val name: String?
)