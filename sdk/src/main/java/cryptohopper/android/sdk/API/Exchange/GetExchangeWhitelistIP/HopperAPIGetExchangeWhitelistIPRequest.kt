package cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetExchangeWhitelistIPRequest : HopperAPIRequest<HopperAPIGetExchangeWhitelistIPResponse> {

    constructor(exchange: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/exchange/$exchange/ipwhitelist")
    }
}