package cryptohopper.android.sdk.API.Exchange.GetPortalExchangeKeyMaps

import HopperAPIGetPairOrderBookOfExchangeResponse
import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetPortalExchangeKeyMapsRequest : HopperAPIRequest<HopperAPIGetPairOrderBookOfExchangeResponse> {

    constructor(data: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/portal")
    }
}
