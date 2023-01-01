package cryptohopper.android.sdk.API.Platform.Countries

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetPlatformCountriesRequest : HopperAPIRequest<HopperAPIPlatformCountriesResponse> {

    constructor(data: String) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/platform/countries")
    }
}