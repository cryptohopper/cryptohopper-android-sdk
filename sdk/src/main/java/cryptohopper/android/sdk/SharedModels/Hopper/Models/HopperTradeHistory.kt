package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class HopperTradeHistory (
        @SerializedName("id") val id: String?,
        @SerializedName("exchange") val exchange: String?,
        @SerializedName("currency") val currency: String?,
        @SerializedName("pair") val pair: String?,
        @SerializedName("type") val type: String?,
        @SerializedName("order_cur") val orderCur: String?,
        @SerializedName("order_id") val orderId: String?,
        @SerializedName("date") val date: String?,
        @SerializedName("amount") val amount: String?,
        @SerializedName("rate") val rate: String?,
        @SerializedName("total") val total: String?,
        @SerializedName("fee") val fee: String?,
        @SerializedName("result") val result: String?,
        @SerializedName("trigger_strategy") val triggerStrategy: String?,
        @SerializedName("strategy_result") val strategyResult: TAValue?,
        @SerializedName("buy_id") val buyId: String?,
        @SerializedName("is_short") val isShort: String?,
        @SerializedName("result_short") val resultShort: String?
)