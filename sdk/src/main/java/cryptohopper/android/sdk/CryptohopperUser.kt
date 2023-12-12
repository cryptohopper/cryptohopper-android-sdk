import cryptohopper.android.sdk.API.Platform.Countries.HopperAPICountriesResult
import cryptohopper.android.sdk.API.Platform.Countries.HopperAPIGetPlatformCountriesRequest
import cryptohopper.android.sdk.API.Platform.Countries.HopperAPIPlatformCountriesResponse
import cryptohopper.android.sdk.API.User.Check2FAReset.HopperAPICheck2FAResetRequest
import cryptohopper.android.sdk.API.User.CheckPasswordReset.HopperAPICheckPasswordResetRequest
import cryptohopper.android.sdk.API.User.General.DeleteUser.HopperAPIDeleteUserRequest
import cryptohopper.android.sdk.API.User.General.GetMobileNotifications.HopperAPIUpdateGetMobileNotificationRequest
import cryptohopper.android.sdk.API.User.General.GetMobileNotifications.HopperAPIUpdateGetMobileNotificationResponse
import cryptohopper.android.sdk.API.User.General.RegisterUser.HopperAPIRegisterUserResponse
import cryptohopper.android.sdk.API.User.General.UpdateMobilePushNotification.HopperAPIUpdatePushNotificationRequest
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIError

class CryptohopperUser {

    companion object {

        // ------------- GENERAL ----------------------------------------

        /// Get User Profile
        ///
        fun getUserProfile(callback: (UserProfile?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserProfileRequest("").request<HopperAPIGetUserProfileResponse>({ data ->
                callback(data.userProfile, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Profile
        ///
        fun forgetPassword(
            email: String,
            userAgent: String,
            appCheckToken : String?,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIForgetPasswordRequest(
                email,
                userAgent,
                appCheckToken
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        ///  Check 2FA Reset
        ///
        fun check2FAReset(
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPICheck2FAResetRequest(
                ""
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        ///  Check Password reset
        ///
        fun checkPasswordReset(
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPICheckPasswordResetRequest(
                ""
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Update User Profile
        ///
        ///- Parameter name: (required) name
        ///- Parameter addressOne: (required) address one
        ///- Parameter addressTwo: (required) address two
        ///- Parameter city: (required) city
        ///- Parameter region: (required) region
        ///- Parameter country: (required) country
        ///- Parameter postalCode: (required) postal code
        ///- Parameter phone: (required) phone
        ///- Parameter website: (required) website
        fun updateUserProfile(
            name: String?,
            addressOne: String?,
            addressTwo: String?,
            city: String?,
            region: String?,
            country: String?,
            postalCode: String?,
            phone: String?,
            website: String?,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIUpdateUserProfileRequest(
                name,
                addressOne,
                addressTwo,
                city,
                region,
                country,
                postalCode,
                phone,
                website
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get Available Credits
        ///
        fun getAvailableCredits(callback: (Int?, HopperAPIError?) -> Unit) {
            HopperAPIGetAvailableCreditsRequest("").request<HopperAPIGetAvailableCreditsResponse>({ data ->
                callback(data.credit, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get Mobile Notification
        ///
        fun getMobilePushNotificationPrefs(callback: (Map<String, String>?, HopperAPIError?) -> Unit) {
            HopperAPIUpdateGetMobileNotificationRequest("").request<HopperAPIUpdateGetMobileNotificationResponse>(
                { data ->
                    callback(data.notifications, null)
                },
                { error ->
                    callback(null, error)
                })
        }


        /// Update Mobile Notification
        ///
        fun updateMobilePushNotificationPrefs(
            permissions: Map<String, String>,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIUpdatePushNotificationRequest(permissions).request<HopperCommonMessageResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }


        /// Get User Email
        ///
        fun getUserEmail(callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserEmailRequest("").request<HopperAPIGetUserEmailResponse>({ data ->
                callback(data.email, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get User Email
        ///
        ///- Parameter email: (required) email
        fun changeEmail(email: String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIChangeEmailRequest(email).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Enable Mobile Push Notifications
        ///
        ///- Parameter enableAll: (required) enable all permissions
        ///- Parameter permissions: (required)  enable with some permissions
        fun enableMobilePushNotification(
            enableAll: Boolean,
            permissions: List<PushNotificationPermissions>,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIEnablePushNotificationRequest(
                enableAll,
                permissions
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get User Id
        ///
        fun getUserId(callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserIdRequest("").request<HopperAPIGetUserIdResponse>({ data ->
                callback(data.id, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Notifications
        ///
        fun getUserNotifications(callback: (List<UserNotification>?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserNotificationsRequest("").request<HopperAPIGetUserNotificationsResponse>(
                { data ->
                    callback(data.notifications, null)
                },
                { error ->
                    callback(null, error)
                })
        }


        /// Change Password
        ///
        ///- Parameter newPassword: (required) your new password
        fun changePassword(newPassword: String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIChangePasswordRequest(newPassword).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Purchases
        ///
        ///
        fun getUserPurchases(callback: (List<UserPurchase>?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserPurchasesRequest("").request<HopperAPIGetUserPurchasesResponse>({ data ->
                callback(data.purchases, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Change Password
        ///
        ///- Parameter name: (required) name
        ///- Parameter email: (required) email
        ///- Parameter username: (required) username
        ///- Parameter subscribeNewsletter: (required) subscribe newsletter
        ///- Parameter password: (required) password
        fun registerUser(
            name: String,
            email: String,
            username: String,
            subscribeNewsLetter: Boolean,
            password: String,
            userAgent: String,
            appCheckToken : String?,
            callback: (HopperAPIRegisterUserResponse?, HopperAPIError?) -> Unit
        ) {
            HopperAPIRegisterUserRequest(
                name,
                email,
                username,
                subscribeNewsLetter,
                password,
                userAgent,
                appCheckToken
            ).request<HopperAPIRegisterUserResponse>({ data ->
                callback(data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Resend Activation Email
        ///
        ///
        ///- Parameter email: (required) email
        ///- Parameter username: (required) username
        fun resendActivationEmail(
            email: String,
            username: String,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIResendActivationEmailRequest(
                email,
                username
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Transactions
        ///
        ///
        fun getUserTransactions(callback: (List<UserTransaction>?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserTransactionsRequest("").request<HopperAPIGetUserTransactionsResponse>({ data ->
                callback(data.transactions, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Metadata
        ///
        ///
        fun getUserMetadata(callback: (UserMetadata?, HopperAPIError?) -> Unit) {
            HopperAPIGetUserMetadataRequest("").request<HopperAPIGetUserMetadataResponse>({ data ->
                callback(data.metadata, null)
            }, { error ->
                callback(null, error)
            })
        }

        /// Get User Metadata
        ///
        ///
        ///- Parameter code: (required) Two factor authentication code
        fun validateTwoFactorAuth(code: String, callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIValidateTwoFactorAuthRequest(code).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }


        // ------------- Subscription ----------------------------------------

        /// Get All User Subscriptions
        ///
        ///
        fun getAllUserSubscriptions(callback: (List<UserSubscription>?, HopperAPIError?) -> Unit) {
            HopperAPIGetAllUserSubscriptionsRequest("").request<HopperAPIGetAllUserSubscriptionsResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get One Subscription
        ///
        ///
        ///- Parameter subscriptionId: (required) Subscription Id
        fun getOneUserSubscriptions(
            subscriptionId: Int,
            callback: (UserSubscription?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetOneUserSubscriptionRequest(subscriptionId).request<HopperAPIGetOneUserSubscriptionResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get All Subscription Plans
        ///
        ///
        fun getAllSubscriptionPlans(callback: (List<SubscriptionPlan>?, HopperAPIError?) -> Unit) {
            HopperAPIGetAllSubscriptionPlansRequest("").request<HopperAPIGetAllSubscriptionPlansResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Get One Subscription Plan
        ///
        ///
        ///- Parameter planId: (required) Plan Id
        fun getOneSubscriptionPlan(
            planId: Int,
            callback: (SubscriptionPlan?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetOneSubscriptionPlanRequest(planId).request<HopperAPIGetOneSubscriptionPlanResponse>(
                { data ->
                    callback(data.data, null)
                },
                { error ->
                    callback(null, error)
                })
        }

        /// Assign Subscriotion
        ///
        ///
        ///- Parameter hopperId: (required) Hopper Id
        ///- Parameter subscriptionId: (required) Subscription Id
        fun assignSubscription(
            hopperId: Int,
            subscriptionId: Int,
            callback: (String?, HopperAPIError?) -> Unit
        ) {
            HopperAPIAssignSubscriptionRequest(
                hopperId,
                subscriptionId
            ).request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }
        /// Delete User
        ///
        ///
        fun deleteUser(callback: (String?, HopperAPIError?) -> Unit) {
            HopperAPIDeleteUserRequest("").request<HopperCommonMessageResponse>({ data ->
                callback(data.data, null)
            }, { error ->
                callback(null, error)
            })
        }


        /// Get One Subscription Plan
        ///
        ///
        fun getCountries(
            callback: (HopperAPICountriesResult?, HopperAPIError?) -> Unit
        ) {
            HopperAPIGetPlatformCountriesRequest("").request<HopperAPICountriesResult>(
                { data ->
                    callback(data, null)
                },
                { error ->
                    callback(null, error)
                })
        }
    }
}