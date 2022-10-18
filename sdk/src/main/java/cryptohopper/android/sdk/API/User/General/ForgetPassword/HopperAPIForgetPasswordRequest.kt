
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIForgetPasswordRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(
        email : String,
        userAgent: String,
        appCheckToken: String?
    ) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = false
        this.changeUrlPath("/user/resetpassword")
        addBodyItem( "email", email)
        addHeader("User-Agent", userAgent)

        if(appCheckToken != null){
            addHeader("X-Firebase-AppCheck",(appCheckToken?: ""))
        }
    }

}