import cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments.HopperAPIV2GetAllTournamentsRequest
import cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments.V2Tournament
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Tournament {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Tournaments
        fun getTournaments(callback: (List<V2Tournament>?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetAllTournamentsRequest().request<List<V2Tournament>>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}