package cryptohopper.android.sdk.API.apiv2.strategies.getstrategies

import com.google.gson.annotations.SerializedName

data class V2Strategy(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("image") val image: Double?,
    @SerializedName("createdAt") val createdAt: Double?,
    @SerializedName("updatedAt") val updatedAt: Int?,
    @SerializedName("risk") val risk: Double?,
    @SerializedName("availableCoins") val availableCoins: List<String>?
)



