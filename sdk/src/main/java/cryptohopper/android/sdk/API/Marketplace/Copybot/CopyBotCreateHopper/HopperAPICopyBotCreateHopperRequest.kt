package cryptohopper.android.sdk.API.Marketplace.Copybot.CopyBotCreateHopper

import HopperAPIRequest
import cryptohopper.android.sdk.API.Purchase.General.HopperAPIPurchaseResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPICopyBotCreateHopperRequest : HopperAPIRequest<HopperAPIPurchaseResponse> {

    constructor(hopperId : String?, copyBotMarketplaceId  : String, paperTrading: Boolean, apiKey : String? , apiSecret : String? , apiPassphrase : String? , extraApiKey : String? , extraApiSecret : String?,autoSync : Boolean = true, isSandbox : Boolean = false ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/app/mobile/iap")
        addBodyItem( "platform", "android")
        addBodyItem( "marketplace_id", copyBotMarketplaceId)
        addBodyItem( "load_into_bot", "0")
        addBodyItem( "free_trial", "1")
        addBodyItem( "walletscrubber", "1")
        addBodyItem( "autosync", "1")

        if((hopperId?: "") != ""){
            addBodyItem("load_into_bot",hopperId!!)
        }
        if(autoSync){
            addBodyItem("autosync","1")
        }
        if(paperTrading){
            addBodyItem( "paper_trading", "1")
        }else{
            addBodyItem( "paper_trading", "0")
        }
        if(apiKey != null){
            addBodyItem( "api_key", apiKey)
        }
        if(apiSecret != null){
            addBodyItem( "api_secret", apiSecret)
        }
        if(apiPassphrase != null){
            addBodyItem( "api_passphrase", apiPassphrase)
        }
        if(extraApiKey != null){
            addBodyItem( "extra_api_key", extraApiKey)
        }
        if(extraApiSecret != null){
            addBodyItem( "extra_api_secret", extraApiSecret)
        }
        if(isSandbox){
            addBodyItem("sandbox","1")
        }
    }
}