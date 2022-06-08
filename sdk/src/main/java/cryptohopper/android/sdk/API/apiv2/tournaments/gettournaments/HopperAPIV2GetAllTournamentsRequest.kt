package cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments


import HopperAPIRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIV2GetAllTournamentsRequest : HopperAPIRequest<List<V2Tournament>> {

    constructor() {
        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath(path = "/rest/api/v2/tournaments/list", isV2Endpoint = true)
    }
}
