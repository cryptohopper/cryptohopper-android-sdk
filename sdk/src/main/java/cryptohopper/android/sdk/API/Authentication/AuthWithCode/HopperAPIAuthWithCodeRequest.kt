package cryptohopper.android.sdk.API.Authentication.AuthWithCode

import HopperAPIAuthenticationResponse
import HopperAPIRequest
import cryptohopper.android.sdk.API.Hopper.General.CreateHopper.HopperAPICreateHopperResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIAuthWithCodeRequest: HopperAPIRequest<HopperAPIAuthenticationResponse> {

    constructor(code: String, userAgent: String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.setIsAuthenticationRequest(true)
        this.changeUrlPath("/oauth2/token")
        addBodyItem( "grant_type", "authorization_code")
        addBodyItem( "client_id", HopperAPIConfigurationManager.shared.config.clientId!!)
        addBodyItem( "code", code)
        addBodyItem( "scope", "read,user,notifications,trade,manage")
        addHeader("User-Agent",userAgent)
    }

}