package cryptohopper.android.sdk

import HopperAPIAuthenticationRequest
import HopperAPIAuthenticationResponse
import HopperCommonMessageResponse
import HopperError
import android.content.Context
import cryptohopper.android.sdk.API.Authentication.AuthWithCode.HopperAPIAuthWithCodeRequest
import cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice.HopperAPIAuthDeviceCheckIfAuthorizedRequest
import cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice.HopperAPIAuthDeviceGetListRequest
import cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice.HopperAPIAuthDeviceResendEmailRequest
import cryptohopper.android.sdk.API.Authentication.DeviceCheck.AuthorizeDevice.HopperAPIAuthDeviceRevokeRequest
import cryptohopper.android.sdk.API.Authentication.DeviceCheck.HopperAPIAuthDeviceWithCodeRequest
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
            appCheckToken : String?,
            deviceName: String?,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthenticationRequest(
                username,
                password,
                verificationCode,
                userAgent,
                appCheckToken,
                deviceName
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
            appCheckToken : String?,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPISocialLoginRequest(
                socialType,
                token,
                nonce,
                userAgent,
                appCheckToken
            ).request<HopperAPIAuthenticationResponse>({ response ->
                HopperAPISessionManager.shared.handleAuthResponse(response)
                callback("Successfully Logged In", null)
            }, { error ->
                callback(null, error)
            })
        }

        //----------DEVICE AUTHORIZATION---------

        /*!
         *
         * @discussion Device authorization with code
         *
         * @param code String
         */

        fun authDeviceWithCode(
            code: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthDeviceWithCodeRequest(
                code
            ).request<HopperCommonMessageResponse>({ response ->
                callback((response.message?: ""), null)
            }, { error ->
                callback(null, error)
            })
        }

        /*!
        *
         * @discussion Device authorization resend email (60 second cooldown)
        *
        */

        fun authDeviceResendEmail(
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthDeviceResendEmailRequest(
                ""
            ).request<HopperCommonMessageResponse>({ response ->
                callback((response.message?: ""), null)
            }, { error ->
                callback(null, error)
            })
        }

        /*!
        *
        * @discussion Device authorization check if device authorized
        *
        */

        fun authDeviceCheck(
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthDeviceCheckIfAuthorizedRequest(
                ""
            ).request<HopperCommonMessageResponse>({ response ->
                callback((response.message?: ""), null)
            }, { error ->
                callback(null, error)
            })
        }

        /*!
        *
        * @discussion Device authorization get list
        *
        */

        fun authDeviceList(
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthDeviceGetListRequest(
                ""
            ).request<HopperCommonMessageResponse>({ response ->
                callback((response.message?: ""), null)
            }, { error ->
                callback(null, error)
            })
        }

        /*!
        *
        * @discussion Device authorization revoke device
        *
        */

        fun authDeviceRevoke(
            deviceId : String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAuthDeviceRevokeRequest(
                deviceId = deviceId
            ).request<HopperCommonMessageResponse>({ response ->
                callback((response.message?: ""), null)
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