import cryptohopper.android.sdk.API.apiv2.user.TestKeys.HopperAPIV2TestApiKeyRequest
import cryptohopper.android.sdk.API.apiv2.user.TestKeys.HopperAPIV2TestApiKeyResponse
import cryptohopper.android.sdk.API.apiv2.user.balancecheck.HopperAPIV2CheckUserBalanceRequest
import cryptohopper.android.sdk.API.apiv2.user.createcontactmessage.HopperAPIV2CreateContactMessageRequest
import cryptohopper.android.sdk.API.apiv2.user.editprofile.HopperAPIV2EditUserPropertiesRequest
import cryptohopper.android.sdk.API.apiv2.user.getuser.HopperAPIV2GetUserProfileRequest
import cryptohopper.android.sdk.API.apiv2.user.getuser.V2User
import cryptohopper.android.sdk.API.apiv2.user.username.HopperAPIV2CheckUsernameRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperV2User {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get UserProfile
        fun getUserProfile(callback: (V2User?, HopperAPIError?) -> Unit) {
            HopperAPIV2GetUserProfileRequest().request<V2User>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Edit UserProfile
        fun editUserProperties(properties: HashMap<String, Any>, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIV2EditUserPropertiesRequest(properties).request<HopperCommonMessageResponse>({ data ->
                callback("Success", null)
            }, { error ->
                callback(null, error)
            })
        }

        ///checkUserBalance
        fun checkUserBalance(exchangeKey : String, apiProperties : HashMap<String, Any>, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIV2CheckUserBalanceRequest(exchangeKey, apiProperties).request<HopperCommonMessageResponse>({ data ->
                callback("Success!, Check From WS", null)
            }, { error ->
                callback(null, error)
            })
        }

        ///checkUsername
        fun checkUsername(username : String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIV2CheckUsernameRequest(username).request<Boolean>({ data ->
                callback("Success!", null)
            }, { error ->
                callback(null, error)
            })
        }

        ///createContactMessage
        fun createContactMessage(email: String, message: String, name: String, subject: String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIV2CreateContactMessageRequest(email, message, name, subject).request<HopperCommonMessageResponse>({ data ->
                callback("Success!", null)
            }, { error ->
                callback(null, error)
            })
        }

        fun testKeys(exchange : String?,apiKey : String?,apiSecret : String?,apiPassphrase : String?,extraApiKey : String?,extraApiSecret : String?,subAccount : String?, callback: (Map<String,Double>?, HopperAPIError?) -> Unit) {
            HopperAPIV2TestApiKeyRequest(exchange, apiKey, apiSecret, apiPassphrase,extraApiKey, extraApiSecret, subAccount).request<HopperAPIV2TestApiKeyResponse>({ data ->
                callback(data?.balances, null)
            }, { error ->
                callback(null, error)
            })
        }
    }
}