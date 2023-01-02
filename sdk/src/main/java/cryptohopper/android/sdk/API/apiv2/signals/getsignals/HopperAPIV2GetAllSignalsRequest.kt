package cryptohopper.android.sdk.API.apiv2.signals.getsignals


import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetAllSignalsRequest : HopperAPIRequest<List<V2Signal>> {

    constructor(exchange: String?) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/signal/list", isV2Endpoint = true)

        if (exchange != null)
            addQueryItem("exchange", exchange)
    }
}
