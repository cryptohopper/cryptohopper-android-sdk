package cryptohopper.android.sdk.API.Platform.Countries

import com.google.gson.annotations.SerializedName

data class HopperAPIPlatformCountriesResponse (
    @SerializedName("data") val data: HopperAPICountriesResult?
)

data class HopperAPICountriesResult (
    @SerializedName("countries") val countries: Map<String,String>?,
    @SerializedName("ip_country ") val ipCountry : String?
)