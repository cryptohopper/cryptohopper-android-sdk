package cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAuthDeviceRevokeRequest(deviceId : String) :
    HopperAPIRequest<HopperCommonMessageResponse>() {

    init {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/device/$deviceId/revoke")
    }

}