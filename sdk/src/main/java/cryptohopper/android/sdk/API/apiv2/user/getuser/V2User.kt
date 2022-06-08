package cryptohopper.android.sdk.API.apiv2.user.getuser

import com.google.gson.annotations.SerializedName

data class V2User(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name : String?,
    @SerializedName("username") val username : String?,
    @SerializedName("registeredAtAt") val registeredAtAt : String?,
    @SerializedName("lastVisitedAt") val lastVisitedAt : String?,
    @SerializedName("email") val email : String?,
    @SerializedName("country") val country : String?,
    @SerializedName("blocked") val blocked : Boolean?
)



