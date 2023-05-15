package cryptohopper.android.sdk.API.apiv2.onboarding.createonboardinghopper


import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2OnboardingCreateRequest : HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(
        hopperId: Int,
        isBuyingEnabled: Boolean,
        isSellingEnabled: Boolean,
        isHopperEnabled: Boolean,
        isPortfolioSyncEnabled: Boolean,
        isPaperTrading: Boolean,
        quoteCurrency: String,
        signallerId: Int?,
        riskLevel: String?
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath(path = "/onboarding/create", isV2Endpoint = true)

        val exchangeObject = HashMap<String, Any>()
        exchangeObject["paperTrading"] = isPaperTrading
        exchangeObject["quoteCurrency"] = quoteCurrency
        addBodyItem("exchange", exchangeObject)

        val settingsObject = HashMap<String, Any>()
        settingsObject["id"] = hopperId
        settingsObject["buying"] = isBuyingEnabled
        settingsObject["selling"] = isSellingEnabled
        settingsObject["enabled"] = isHopperEnabled
        settingsObject["autosync"] = isPortfolioSyncEnabled

        val botObject = HashMap<String, Any>()
        botObject["settings"] = settingsObject

        if (signallerId != null) {
            val signalObject = HashMap<String, Any>()
            signalObject["signallerId"] = signallerId
            botObject["signal"] = signalObject
        }

        if (riskLevel != null) {
            val strategyObject = HashMap<String, Any>()
            strategyObject["riskLevel"] = riskLevel
            botObject["strategy"] = strategyObject
        }

        addBodyItem( "bot",  botObject)
    }
}
