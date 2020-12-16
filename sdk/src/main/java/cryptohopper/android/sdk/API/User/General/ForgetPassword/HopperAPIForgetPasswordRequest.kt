
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIForgetPasswordRequest: HopperAPIRequest<HopperCommonMessageResponse> {

    constructor(email : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/user/resetpassword")
        addBodyItem( "email", email)
    }

}