//
//  HopperAPIGetBasicTemplatesResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetBasicTemplatesResponse (
        @SerializedName("data") val basicTemplates: List<BasicTemplate>?
)


