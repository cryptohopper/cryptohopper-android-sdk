/**
 * HopperAPIGetAIsRequest.kt
 * @author Malik Dawar
 */

import cryptohopper.android.sdk.API.AI.General.GetAIs.HopperAPIGetAIsResponse
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIGetAIsRequest: HopperAPIRequest<HopperAPIGetAIsResponse> {
    
    constructor() {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/ai")
    }
}
