package cryptohopper.android.sdk.API.apiv2.currencies

import com.google.gson.annotations.SerializedName

data class V2Currency(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("ticker") val ticker: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("isStableCoin") val isStableCoin: String?
)



