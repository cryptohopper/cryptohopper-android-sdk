package cryptohopper.android.sdk.API.apiv2.user.balancecheck


import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2CheckUserBalanceRequest : HopperAPIRequest<HopperCommonMessageResponse?> {

    constructor(exchangeKey : String, apiProperties : HashMap<String, Any>) {

        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath(path = "/user/balances", isV2Endpoint = true)
        addBodyItem("exchange", exchangeKey)
        apiProperties.forEach {
            addBodyItem(it.key, it.value)
        }
    }
}
