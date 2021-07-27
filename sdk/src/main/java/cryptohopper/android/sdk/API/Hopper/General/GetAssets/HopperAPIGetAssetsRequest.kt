package cryptohopper.android.sdk.API.Hopper.General.GetAssets

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetAssetsRequest: HopperAPIRequest<HopperAPIGetAssetsResponse> {

    constructor(id : String,reserved : Boolean) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$id/assets")
        addQueryItem("reserved", (if (reserved) "1" else "0"))
    }

}