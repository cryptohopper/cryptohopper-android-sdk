package cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP

import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.API.Platform.Countries.HopperAPICountriesResult

data class HopperAPIGetExchangeWhitelistIPResponse (
    @SerializedName("data") val data: CHIPWhitelist ?
)

data class CHIPWhitelist  (
    @SerializedName("ip_addresses") val ips: String?,
    @SerializedName("show_ip_addresses") val showIpAddresses: String?,
    @SerializedName("copy_ip_addresses") val copyIPAddresses: String?
)