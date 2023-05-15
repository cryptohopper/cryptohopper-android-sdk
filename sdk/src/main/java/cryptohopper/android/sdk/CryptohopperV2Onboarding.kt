import cryptohopper.android.sdk.API.apiv2.onboarding.createonboardinghopper.HopperAPIV2OnboardingCreateRequest
import cryptohopper.android.sdk.API.apiv2.onboarding.editonboardinghopper.HopperAPIV2OnboardingEditRequest
import cryptohopper.android.sdk.API.apiv2.onboarding.intonboarding.HopperAPIV2OnboardingInitRequest
import cryptohopper.android.sdk.API.apiv2.onboarding.intonboarding.HopperAPIV2OnboardingInitResponse
import cryptohopper.android.sdk.API.apiv2.user.balancecheck.HopperAPIV2CheckUserBalanceRequest
import cryptohopper.android.sdk.API.apiv2.user.createcontactmessage.HopperAPIV2CreateContactMessageRequest
import cryptohopper.android.sdk.API.apiv2.user.editprofile.HopperAPIV2EditUserPropertiesRequest
import cryptohopper.android.sdk.API.apiv2.user.getuser.HopperAPIV2GetUserProfileRequest
import cryptohopper.android.sdk.API.apiv2.user.getuser.V2User
import cryptohopper.android.sdk.API.apiv2.user.username.HopperAPIV2CheckUsernameRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2Onboarding {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// init Onboarding
        fun initOnboarding(
            exchangeId: Int,
            apiDetails: HashMap<String, Any>,
            isPaperTrading: Boolean,
            quoteCurrency: String,
            callback: (Int?, HopperAPIError?) -> Unit
        ) {
            HopperAPIV2OnboardingInitRequest(
                exchangeId,
                apiDetails,
                isPaperTrading,
                quoteCurrency
            ).request<HopperAPIV2OnboardingInitResponse>({ data ->
                callback(data.id, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Edit Onboarding
        fun editOnboarding(
            hopperId: Int,
            exchangeId: Int,
            apiDetails: HashMap<String, Any>,
            isPaperTrading: Boolean, quoteCurrency: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIV2OnboardingEditRequest(
                hopperId,
                exchangeId,
                apiDetails,
                isPaperTrading,
                quoteCurrency
            ).request<HopperCommonMessageResponse>({ data ->
                callback("Success", null)
            }, { error ->
                callback(null, error)
            })
        }

        ///create OnboardingHopper
        fun createOnboardingHopper(
            hopperId: Int,
            isBuyingEnabled: Boolean,
            isSellingEnabled: Boolean,
            isHopperEnabled: Boolean,
            isPortfolioSyncEnabled : Boolean,
            isPaperTrading: Boolean,
            quoteCurrency: String,
            signallerId: Int?,
            riskLevel: String?,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIV2OnboardingCreateRequest(
                hopperId,
                isBuyingEnabled,
                isSellingEnabled,
                isHopperEnabled,
                isPortfolioSyncEnabled,
                isPaperTrading,
                quoteCurrency,
                signallerId,
                riskLevel
            ).request<HopperCommonMessageResponse>({ data ->
                callback("Success", null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}