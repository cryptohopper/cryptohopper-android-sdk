package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class HopperUnsynedPosition (
        @SerializedName("pair") val pair: String?,
        @SerializedName("cur") val currency: String?,
        @SerializedName("amount") val amount: Double?,
        @SerializedName("rate") val rate: String?
)