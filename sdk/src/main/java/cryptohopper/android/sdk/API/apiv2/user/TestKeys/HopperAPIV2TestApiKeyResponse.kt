package cryptohopper.android.sdk.API.apiv2.user.TestKeys

import com.google.gson.annotations.SerializedName

data class HopperAPIV2TestApiKeyResponse(
    @SerializedName("balances") val balances: Map<String,Double>?
)
