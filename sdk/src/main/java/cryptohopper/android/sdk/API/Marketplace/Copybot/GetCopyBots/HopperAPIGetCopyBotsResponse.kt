package cryptohopper.android.sdk.API.Marketplace.Copybot.GetCopyBots

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Marketplace.Models.MarketCopyBot

data class HopperAPIGetCopyBotsResponse(
    @SerializedName("data") val data: GetCopyBotsResponse?
)

data class GetCopyBotsResponse(
    @SerializedName("copybots") val copybots : List<MarketCopyBot>?
)