package cryptohopper.android.sdk

import HopperAPIAuthenticationRequest
import HopperAPIAuthenticationResponse
import HopperError
import android.content.Context
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment

class CryptohopperAuth {

    companion object {

        fun login(username: String,password: String,verificationCode: String?,userAgent : String,callback: (String?,HopperError?) -> Unit) {
            HopperAPIAuthenticationRequest(username,password,verificationCode,userAgent).request<HopperAPIAuthenticationResponse>({response ->
                HopperAPISessionManager.shared.handleAuthResponse(response)
                callback("Successfully Logged In",null)
            },{error ->
                callback(null,error)
            })
        }

        fun logout() {
            HopperAPISessionManager.shared.removeSession()
        }

        fun isAuthenticated(): Boolean {
            return HopperAPISessionManager.shared.hasSession
        }

    }

}