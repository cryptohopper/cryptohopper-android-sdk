package cryptohopper.android.sdk.API.apiv2.onboarding.intonboarding

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2OnboardingInitRequest : HopperAPIRequest<HopperAPIV2OnboardingInitResponse> {

    constructor(
        exchangeId: Int,
        apiDetails: HashMap<String, Any>,
        isPaperTrading: Boolean, quoteCurrency: String
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath(path = "/onboarding/init", isV2Endpoint = true)

        val exchangeObject = HashMap<String, Any>()
        exchangeObject["id"] = exchangeId
        apiDetails.forEach {
            exchangeObject[it.key] = it.value
        }
        addBodyItem( "exchange",  exchangeObject)
        addBodyItem( "paperTrading",  isPaperTrading)
        addBodyItem( "quoteCurrency",  quoteCurrency)
    }
}
