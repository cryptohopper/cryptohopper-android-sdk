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
        this.changeUrlPath(path = "/test-keys", isV2Endpoint = true)
        this.needsAuthentication = true
        if (exchange != null) {
            addBodyItem("exchange", (exchange?: ""))
        }
        if (apiKey != null) {
            addBodyItem("apiKey", (apiKey?: ""))
        }
        if (apiSecret != null) {
            addBodyItem("apiSecret", (apiSecret?: ""))
        }
        if (apiPassphrase != null) {
            addBodyItem("apiPassphrase", (apiPassphrase?: ""))
        }
        if (extraApiKey != null) {
            addBodyItem("extraApiKey", (extraApiKey?: ""))
        }
        if (extraApiSecret != null) {
            addBodyItem("extraApiSecret", (extraApiSecret?: ""))
        }
        if (subAccount != null) {
            addBodyItem("subAccount", (subAccount?: ""))
        }
    }
}