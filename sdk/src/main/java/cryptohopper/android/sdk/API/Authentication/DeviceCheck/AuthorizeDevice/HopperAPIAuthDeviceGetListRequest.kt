package cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAuthDeviceGetListRequest(data: String) :
    HopperAPIRequest<HopperAPIAuthDeviceGetListResponse>() {

    init {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/device/list")
    }

}