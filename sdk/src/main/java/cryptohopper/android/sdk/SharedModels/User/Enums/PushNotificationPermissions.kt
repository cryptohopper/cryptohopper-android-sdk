//
//  PushNotificationPermissions.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName

enum class PushNotificationPermissions(val rawValue: String) {
    @SerializedName("config_error") CONFIG_ERROR("config_error"),
    @SerializedName("on_first_start") ON_FIRST_START("on_first_start"),
    @SerializedName("on_trigger") ON_TRIGGER("on_trigger"),
    @SerializedName("on_panic_start") ON_PANIC_START("on_panic_start"),
    @SerializedName("on_panic_end") ON_PANIC_END("on_panic_end"),
    @SerializedName("order_placed") ORDER_PLACED("order_placed"),
    @SerializedName("trade_completed") TRADE_COMPLETED("trade_completed"),
    @SerializedName("order_cancelled") ORDER_CANCELLED("order_cancelled")
}
