import android.content.Context
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment

class CryptoHopperConfig {

    companion object {

        fun configure(
            context: Context,
            clientId: String,
            environment: HopperAPIEnvironment,
            v2Key: String = "",
            v2Value: String = ""
        ) {
            HopperAPIConfigurationManager.shared.config.context = context
            HopperAPIConfigurationManager.shared.config.clientId = clientId
            HopperAPIConfigurationManager.shared.config.environment = environment
            HopperAPIConfigurationManager.shared.config.v2ApiValidationKey = v2Key
            HopperAPIConfigurationManager.shared.config.v2ApiValidationValue = v2Value
        }

    }
}
