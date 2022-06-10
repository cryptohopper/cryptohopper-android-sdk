import cryptohopper.android.sdk.API.apiv2.signals.getsignals.HopperAPIV2GetAllSignalsRequest
import cryptohopper.android.sdk.API.apiv2.signals.getsignals.V2Signal
import cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments.HopperAPIV2GetAllTournamentsRequest
import cryptohopper.android.sdk.API.apiv2.tournaments.gettournaments.V2Tournament
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Signal {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get Signals
        fun getSignals(exchange : String?, callback: (List<V2Signal>?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetAllSignalsRequest(exchange).request<List<V2Signal>>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}