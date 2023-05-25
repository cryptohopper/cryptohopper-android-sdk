package cryptohopper.android.sdk.API.apiv2.exchange.allv2exchange

import com.google.gson.annotations.SerializedName

data class V2Exchange(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("key") val key: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("signupLink") val signupLink: String?,
    @SerializedName("tutorialLink") val tutorialLink: String?,
    @SerializedName("defaultQuoteCurrency") val defaultQuoteCurrency: String?,
    @SerializedName("totalHoppers") val totalHoppers: Int?,
    @SerializedName("totalMarkets") val totalMarkets: Int?,
    @SerializedName("totalTrades") val totalTrades: Int?,
    @SerializedName("uptimeLastHour") val uptimeLastHour: Double?,
    @SerializedName("uptimeLastWeek") val uptimeLastWeek: Double?,
    @SerializedName("uptimeLastMonth") val uptimeLastMonth: Double?,
    @SerializedName("createdAt") val createdAt: String?,
    @SerializedName("updatedAt") val updatedAt: String?,
    @SerializedName("ordering") val ordering: Int?,
    @SerializedName("premiumPartner") val premiumPartner: Boolean?,
    @SerializedName("exchangeStatus") val exchangeStatus: Boolean?,
    @SerializedName("availableSoon") val availableSoon: Boolean?,
    @SerializedName("isBeta") val isBeta: Boolean?,
    @SerializedName("isCeta") val isCeta: Boolean?,
    @SerializedName("status") val status: Boolean?,
    @SerializedName("display") val display: Boolean?,
    @SerializedName("maintenance") val maintenance: Boolean?,
    @SerializedName("margin") val margin: Boolean?,
    @SerializedName("extraLinks") val extraLinks: List<Map<String,String>>?,
    @SerializedName("quoteCurrencies") val quoteCurrencies: List<String>?,
    @SerializedName("images") val images: Map<String?, String?>?,
    @SerializedName("apiConfigFields") val apiConfigFields: List<String>?,
    @SerializedName("optionalConfigFields") val optionalConfigFields: List<String>?,
    @SerializedName("fastApiHook") val fastApiHook: String?
)



