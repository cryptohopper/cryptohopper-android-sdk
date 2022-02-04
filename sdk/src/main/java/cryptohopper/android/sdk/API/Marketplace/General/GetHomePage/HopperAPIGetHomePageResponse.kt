//
//  HopperAPIGetHomePageResponse.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import com.google.gson.annotations.SerializedName

data class HopperAPIGetHomePageResponse(
    @SerializedName("data") val data: HopperAPIGetHomePageData?
)

data class HopperAPIGetHomePageData(
    @SerializedName("featured_home") val featuredHome: List<MarketItem>?,
    @SerializedName("home_editors_pick") val homeEditorsPick: List<MarketItem>?,
    @SerializedName("home_top_signals") val homeTopSignals: List<MarketItem>?,
    @SerializedName("home_best_rated_strategies") val homeBestRatedStrategies: List<MarketItem>?,
    @SerializedName("home_best_rated_templates") val homeBestRatedTemplates: List<MarketItem>?,
    @SerializedName("home_best_rated_signals") val homeBestRatedSignals: List<MarketItem>?
)