package cryptohopper.android.sdk.API.apiv2.exchange.allv2exchange


import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetAllExchangesRequest : HopperAPIRequest<List<V2Exchange>> {

    constructor(data: String? = null) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/rest/api/v2/exchange/list", isV2Endpoint = true)
    }
}
