//
//  UserPurchase.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserPurchase (
    @SerializedName("id") val id: String?,
    @SerializedName("seller_id") val sellerId: String?,
    @SerializedName("buyer_id") val buyerId: String?,
    @SerializedName("transaction_id") val transactionId: String?,
    @SerializedName("item_id") val itemId: String?,
    @SerializedName("item_type") val itemType: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("price") val price: String?,
    @SerializedName("subtotal") val subTotal: String?,
    @SerializedName("tax") val tax: String?,
    @SerializedName("total") val total: String?,
    @SerializedName("user_params") val userParams: String?,
    @SerializedName("tax_id") val taxId: String?,
    @SerializedName("created") val created: String?,
    @SerializedName("current_version") val currentVersion: String?,
    @SerializedName("auto_update") val autoUpdate: String?,
    @SerializedName("update_months") val updateMonths: String?,
    @SerializedName("update_until") val updateUntil: String?,
    @SerializedName("is_eu") val isEu: String?,
    @SerializedName("eu_business") val isEuBusiness: String?,
    @SerializedName("hidden") val hidden: String?,
    @SerializedName("paid") val paid: String?,
    @SerializedName("payout_id") val payoutId: String?,
    @SerializedName("deleted") val deleted: String?,
    @SerializedName("product_name") val productName: String?
)

