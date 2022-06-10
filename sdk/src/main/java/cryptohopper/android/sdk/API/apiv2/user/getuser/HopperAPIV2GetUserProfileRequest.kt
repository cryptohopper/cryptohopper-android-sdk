package cryptohopper.android.sdk.API.apiv2.user.getuser


import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetUserProfileRequest : HopperAPIRequest<V2User?> {

    constructor() {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true

        this.changeUrlPath(path = "/rest/api/v2/user", isV2Endpoint = true)
    }
}
