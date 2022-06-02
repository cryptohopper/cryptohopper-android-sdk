package cryptohopper.android.sdk.API.apiv2.strategies.getstrategies


import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetAllBuiltinStrategiesRequest : HopperAPIRequest<List<V2Strategy>> {

    constructor() {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/rest/api/v2/strategy/list", isV2Endpoint = true)
    }
}
