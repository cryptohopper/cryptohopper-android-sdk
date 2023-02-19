package cryptohopper.android.sdk.API.Marketplace.Copybot.GetCopyBots

import HopperAPIRequest
import cryptohopper.android.sdk.API.Exchange.GetExchangeWhitelistIP.HopperAPIGetExchangeWhitelistIPResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetCopyBotsRequest: HopperAPIRequest<HopperAPIGetCopyBotsResponse> {

    constructor(data : String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = false
        this.changeUrlPath("/market/copybots")
    }
}