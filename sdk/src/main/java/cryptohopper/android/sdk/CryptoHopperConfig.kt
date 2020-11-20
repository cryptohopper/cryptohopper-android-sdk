
import android.content.Context
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment

class CryptoHopperConfig {

    companion object {

        fun configure(context : Context, clientId: String, environment: HopperAPIEnvironment) {
            HopperAPIConfigurationManager.shared.config.context = context
            HopperAPIConfigurationManager.shared.config.clientId = clientId
            HopperAPIConfigurationManager.shared.config.environment = environment
        }

    }

}
