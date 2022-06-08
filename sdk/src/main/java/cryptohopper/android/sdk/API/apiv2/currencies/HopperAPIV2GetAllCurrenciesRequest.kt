package cryptohopper.android.sdk.API.apiv2.currencies


import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetAllCurrenciesRequest : HopperAPIRequest<List<V2Currency>> {

    constructor(data: String? = null) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/rest/api/v2/currencies/list", isV2Endpoint = true)
    }
}
