package cryptohopper.android.sdk.API.Authentication.DeviceCheck

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAuthDeviceWithCodeRequest : HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(
        code: String
    ){

        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = false
        this.changeUrlPath("/device/authorize")
        addQueryItem("code", code)
    }

}