package cryptohopper.android.sdk.API.apiv2.signals.getsignals

import com.google.gson.annotations.SerializedName

data class V2Signal(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("createdAt") val createdAt: String?,
    @SerializedName("updatedAt") val updatedAt: String?,
    @SerializedName("riskLevel") val riskLevel: String?,
    @SerializedName("exchanges") val exchanges: List<String>?,
    @SerializedName("noSubscription") val noSubscription: Boolean?,
    @SerializedName("status") val status: Boolean?,
    @SerializedName("deleted") val deleted: Boolean?,
    @SerializedName("cost") val cost: Boolean?,
    @SerializedName("planId") val planId: Int?,
    @SerializedName("links") val links: String?,
    @SerializedName("availableCoins") val availableCoins: List<String>?,
    @SerializedName("subscribersCount") val subscribersCount: Int?,
    @SerializedName("resultSumPerct") val resultSumPerct: Double?,
)

