package cryptohopper.android.sdk.API.apiv2.user.username


import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2CheckUsernameRequest : HopperAPIRequest<Boolean?> {

    constructor(username : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/user/check", isV2Endpoint = true)

        addBodyItem("username", username)
    }
}
