package cryptohopper.android.sdk.API.Hopper.Signal.GetChartData

import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIGetSignalChartDataRequest: HopperAPIRequest<HopperAPIGetSignalChartDataResponse> {

    constructor(signalId : Int) {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/market/signals/$signalId/chartdata")
    }

}