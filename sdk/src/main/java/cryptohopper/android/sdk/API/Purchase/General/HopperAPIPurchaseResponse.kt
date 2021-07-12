package cryptohopper.android.sdk.API.Purchase.General

import com.google.gson.annotations.SerializedName

data class HopperAPIPurchaseResponse (
    @SerializedName("status") val status: Int?,
    @SerializedName("error") val error: Int?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?
)