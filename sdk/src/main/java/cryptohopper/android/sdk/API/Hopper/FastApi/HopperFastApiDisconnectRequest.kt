package cryptohopper.android.sdk.API.Hopper.FastApi

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperFastApiDisconnectRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(hopperId : String){
        this.httpMethod = HopperAPIHttpMethod.DELETE
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/fastapi")
    }


}