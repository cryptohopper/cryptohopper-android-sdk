package cryptohopper.android.sdk.API.apiv2.user.editprofile

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2EditUserPropertiesRequest : HopperAPIRequest<HopperCommonMessageResponse?> {

    constructor(properties: HashMap<String, Any>) {

        this.httpMethod = HopperAPIHttpMethod.PUT
        this.needsAuthentication = true
        this.changeUrlPath(path = "/user", isV2Endpoint = true)

        properties.forEach {
            addBodyItem(it.key, it.value)
        }
    }
}
