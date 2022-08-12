package cryptohopper.android.sdk.API.Authentication.SocialLogin

import HopperAPIAuthenticationResponse
import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPISocialLoginRequest : HopperAPIRequest<HopperAPIAuthenticationResponse> {

    constructor(socialType: String, token: String, nonce: String?, userAgent: String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.setIsAuthenticationRequest(true)
        this.changeUrlPath("/oauth2/social-login")
        addBodyItem( "grant_type", "social")
        addBodyItem( "client_id", HopperAPIConfigurationManager.shared.config.clientId!!)
        addBodyItem( "scope", "read,user,notifications,trade,manage")
        addBodyItem( "social", socialType)
        addBodyItem( "token", token)
        if(nonce != null){
            addBodyItem( "nonce", nonce?: "")
        }
        addHeader("User-Agent",userAgent)
    }
}