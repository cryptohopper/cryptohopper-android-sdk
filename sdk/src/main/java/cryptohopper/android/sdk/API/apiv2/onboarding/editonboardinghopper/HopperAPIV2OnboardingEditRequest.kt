package cryptohopper.android.sdk.API.apiv2.onboarding.editonboardinghopper

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2OnboardingEditRequest : HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(
        hopperId: Int,
        exchangeId: Int,
        apiDetails: HashMap<String, Any>,
        isPaperTrading: Boolean, quoteCurrency: String
    ) {
        this.httpMethod = HopperAPIHttpMethod.PATCH
        this.needsAuthentication = true
        this.changeUrlPath(path = "/onboarding/edit", isV2Endpoint = true)

        val exchangeObject = HashMap<String, Any>()
        exchangeObject["id"] = exchangeId

        apiDetails.forEach {
            exchangeObject[it.key] = it.value
        }
        addBodyItem("exchange", exchangeObject)
        addBodyItem("paperTrading", isPaperTrading)
        addBodyItem("quoteCurrency", quoteCurrency)
        addBodyItem("id", hopperId)
    }
}
