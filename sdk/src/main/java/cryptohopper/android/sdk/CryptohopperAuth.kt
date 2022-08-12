package cryptohopper.android.sdk

import HopperAPIAuthenticationRequest
import HopperAPIAuthenticationResponse
import HopperError
import android.content.Context
import cryptohopper.android.sdk.API.Authentication.AuthWithCode.HopperAPIAuthWithCodeRequest
import cryptohopper.android.sdk.API.Authentication.SocialLogin.HopperAPISocialLoginRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperAuth {

    companion object {

        fun login(
            username: String,
            password: String,
            verificationCode: String?,
            userAgent: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthenticationRequest(
                username,
                password,
                verificationCode,
                userAgent
            ).request<HopperAPIAuthenticationResponse>({ response ->
                HopperAPISessionManager.shared.handleAuthResponse(response)
                callback("Successfully Logged In", null)
            }, { error ->
                callback(null, error)
            })
        }

        fun loginWithCode(
            code: String,
            userAgent: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthWithCodeRequest(
                code,
                userAgent
            ).request<HopperAPIAuthenticationResponse>({ response ->
                HopperAPISessionManager.shared.handleAuthResponse(response)
                callback("Successfully Logged In", null)
            }, { error ->
                callback(null, error)
            })
        }

        /*!
    *
    * @discussion Social login with token
    *
    * @param socialType String
    * @param token String
    * @param nonce String? optional
    */

        fun socialLogin(
            socialType: String,
            token: String,
            nonce: String,
            userAgent: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPISocialLoginRequest(
                socialType,
                token,
                nonce,
                userAgent
            ).request<HopperAPIAuthenticationResponse>({ response ->
                HopperAPISessionManager.shared.handleAuthResponse(response)
                callback("Successfully Logged In", null)
            }, { error ->
                callback(null, error)
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