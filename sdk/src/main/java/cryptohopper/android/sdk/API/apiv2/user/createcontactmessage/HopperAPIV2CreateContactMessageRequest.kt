package cryptohopper.android.sdk.API.apiv2.user.createcontactmessage

import HopperAPIRequest
import HopperCommonMessageResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2CreateContactMessageRequest : HopperAPIRequest<HopperCommonMessageResponse?> {

    constructor(email: String, message: String, name: String, subject: String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath(path = "rest/api/v2/user/contact", isV2Endpoint = true)

        addBodyItem("email", email)
        addBodyItem("message", message)
        addBodyItem("name", name)
        addBodyItem("subject", subject)
    }
}
