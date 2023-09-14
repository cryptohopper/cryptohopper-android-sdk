package cryptohopper.android.sdk.SharedModels.Hopper.Models

import com.google.gson.annotations.SerializedName

data class TroubleshooterItem(
    @SerializedName("title") val title: String?,
    @SerializedName("status") val status: Int?,
    @SerializedName("description") val description: String?
)