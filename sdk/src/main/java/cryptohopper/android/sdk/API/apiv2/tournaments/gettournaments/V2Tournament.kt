package cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments

import com.google.gson.annotations.SerializedName

data class V2Tournament(
    @SerializedName("id") val id: Int?,
    @SerializedName("tournamentType") val tournamentType: String?,
    @SerializedName("papertradingType") val papertradingType: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("logo") val logo: String?,
    @SerializedName("feature") val feature: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("tournamentTerms") val tournamentTerms: String?,
    @SerializedName("links") val links: String?,
    @SerializedName("config") val config: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("quote") val quote: String?,
    @SerializedName("base") val base: String?,
    @SerializedName("startDateJoin") val startDateJoin: String?,
    @SerializedName("endDateJoin") val endDateJoin: String?,
    @SerializedName("startDate") val startDate: String?,
    @SerializedName("endDate") val endDate: String?,
    @SerializedName("updated") val updated: String?,
    @SerializedName("created") val created: String?,
)



