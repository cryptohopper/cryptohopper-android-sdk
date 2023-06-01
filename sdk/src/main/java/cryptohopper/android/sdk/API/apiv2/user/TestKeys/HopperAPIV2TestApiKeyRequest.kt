package cryptohopper.android.sdk.API.apiv2.user.TestKeys

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2TestApiKeyRequest: HopperAPIRequest<HopperAPIV2TestApiKeyResponse?> {

    constructor(
        exchange : String?,
        apiKey : String?,
        apiSecret : String?,
        apiPassphrase : String?,
        extraApiKey : String?,
        extraApiSecret : String?,
        subAccount  : String?,
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.changeUrlPath(path = "/user/test-keys", isV2Endpoint = true)
        this.needsAuthentication = true
        if (exchange != null) {
            addBodyItem("exchange", (exchange?: ""))
        }
        if (apiKey != null) {
            addBodyItem("api_key", (apiKey?: ""))
        }
        if (apiSecret != null) {
            addBodyItem("api_secret", (apiSecret?: ""))
        }
        if (apiPassphrase != null) {
            addBodyItem("api_passphrase", (apiPassphrase?: ""))
        }
        if (extraApiKey != null) {
            addBodyItem("extra_api_key", (extraApiKey?: ""))
        }
        if (extraApiSecret != null) {
            addBodyItem("extra_api_secret", (extraApiSecret?: ""))
        }
        if (subAccount != null) {
            addBodyItem("sub_account", (subAccount?: ""))
        }
    }
}