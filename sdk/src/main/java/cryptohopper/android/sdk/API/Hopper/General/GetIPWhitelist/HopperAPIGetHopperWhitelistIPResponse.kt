package cryptohopper.android.sdk.API.Hopper.General.GetIPWhitelist

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP.CHIPWhitelist

data class HopperAPIGetHopperWhitelistIPResponse (
    @SerializedName("data") val data: CHIPWhitelist?
)
