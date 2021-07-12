package cryptohopper.android.sdk.API.Hopper.General.GetAssets

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetAssetsRequest: HopperAPIRequest<HopperAPIGetAssetsResponse> {

    constructor(id : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$id/assets")
    }

}