package cryptohopper.android.sdk.API.apiv2.strategies.getstrategies

import com.google.gson.annotations.SerializedName

data class V2Strategy(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("createdAt") val createdAt: String?,
    @SerializedName("updatedAt") val updatedAt: String?,
    @SerializedName("risk") val risk: String?,
    @SerializedName("availableCoins") val availableCoins: List<String>?
)



