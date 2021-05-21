//
//  Template.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 04/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class Template (
    @SerializedName("template_id") val templateId: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("base_currency") val baseCurrency: String?,
    @SerializedName("currencies") val currencies: String?,
    @SerializedName("hidden_configuration") val hiddenConfig: String?,
    @SerializedName("hasTriggers") val hasTriggers: Int?,
    @SerializedName("hasConfigPool") val hasConfigPool: Int?,
    @SerializedName("hasSignals") val hasSignals: Int?,
    @SerializedName("allowed_coins") val rating: List<String>?,
    @SerializedName("created_date") val createdDate: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("price_currency") val priceCurrency: String?
)