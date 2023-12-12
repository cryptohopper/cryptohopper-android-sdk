package cryptohopper.android.sdk.API.User.General.DeleteUser

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIDeleteUserRequest : HopperAPIRequest<HopperCommonMessageResponse>{

    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/user")
    }
}