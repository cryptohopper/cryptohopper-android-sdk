package cryptohopper.android.sdk.API.apiv2.exchange


import HopperAPIRequest
import cryptohopper.android.sdk.API.apiv2.exchange.getexchange.V2Pair
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetTradingPairOfExchangeRequest : HopperAPIRequest<V2Pair> {

    constructor(exchangeId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/exchange/$exchangeId/markets", isV2Endpoint = true)
    }
}
