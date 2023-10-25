package cryptohopper.android.sdk.API.Exchange.GetPortalExchangePairMaps

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetPortalExchangePairMapsRequest : HopperAPIRequest<HopperAPIGetPortalExchangePairMapsResponse> {

    constructor(exchangeKey : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchangeKey/portal/pairs")
    }

}