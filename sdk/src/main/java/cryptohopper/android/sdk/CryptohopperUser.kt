import cryptohopper.android.sdk.API.User.General.RegisterUser.HopperAPIRegisterUserResponse

class CryptohopperUser {

    companion object {

        // ------------- GENERAL ----------------------------------------


        /// Get User Profile
        ///
        fun getUserProfile(callback: (UserProfile?, HopperError?) -> Unit) {
            HopperAPIGetUserProfileRequest("").request<HopperAPIGetUserProfileResponse>({ data ->
                   callback(data.userProfile,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Profile
        ///
        fun forgetPassword(email:String,userAgent: String ,callback: (String?, HopperError?) -> Unit) {
            HopperAPIForgetPasswordRequest(email,userAgent).request<HopperCommonMessageResponse>({ data ->
                callback(data.data,null)
            } ,{ error ->
                callback(null,error)
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
        fun updateUserProfile(name : String,addressOne : String,addressTwo : String,city : String,region : String,country : String,postalCode : String,phone : String,website : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIUpdateUserProfileRequest( name,  addressOne,  addressTwo,  city,  region,  country,  postalCode,  phone,  website).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get Available Credits
        ///
        fun getAvailableCredits(callback: (Int?, HopperError?) -> Unit) {
            HopperAPIGetAvailableCreditsRequest("").request<HopperAPIGetAvailableCreditsResponse>({ data ->
                   callback(data.credit,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get User Email
        ///
        fun getUserEmail(callback: (String?, HopperError?) -> Unit) {
            HopperAPIGetUserEmailRequest("").request<HopperAPIGetUserEmailResponse>({ data ->
                   callback(data.email,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get User Email
        ///
        ///- Parameter email: (required) email
        fun changeEmail(email : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIChangeEmailRequest( email).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Enable Mobile Push Notifications
        ///
        ///- Parameter enableAll: (required) enable all permissions
        ///- Parameter permissions: (required)  enable with some permissions
        fun enableMobilePushNotification(enableAll : Boolean,permissions : List<PushNotificationPermissions>,callback: (String?, HopperError?) -> Unit) {
            HopperAPIEnablePushNotificationRequest( enableAll,  permissions).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Get User Id
        ///
        fun getUserId(callback: (String?, HopperError?) -> Unit) {
            HopperAPIGetUserIdRequest("").request<HopperAPIGetUserIdResponse>({ data ->
                   callback(data.id,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Notifications
        ///
        fun getUserNotifications(callback: (List<UserNotification>?, HopperError?) -> Unit) {
            HopperAPIGetUserNotificationsRequest("").request<HopperAPIGetUserNotificationsResponse>({ data ->
                   callback(data.notifications,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Change Password
        ///
        ///- Parameter newPassword: (required) your new password
        fun changePassword(newPassword : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIChangePasswordRequest( newPassword).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Purchases
        ///
        ///
        fun getUserPurchases(callback: (List<UserPurchase>?, HopperError?) -> Unit) {
            HopperAPIGetUserPurchasesRequest("").request<HopperAPIGetUserPurchasesResponse>({ data ->
                   callback(data.purchases,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        /// Change Password
        ///
        ///- Parameter name: (required) name
        ///- Parameter email: (required) email
        ///- Parameter username: (required) username
        ///- Parameter subscribeNewsletter: (required) subscribe newsletter
        ///- Parameter password: (required) password
        fun registerUser(name : String, email : String, username : String, subscribeNewsLetter : Boolean , password : String,userAgent : String,callback: (HopperAPIRegisterUserResponse?, HopperError?) -> Unit) {
            HopperAPIRegisterUserRequest( name,  email,  username,  subscribeNewsLetter,  password, userAgent).request<HopperAPIRegisterUserResponse>({ data ->
                   callback(data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Resend Activation Email
        ///
        ///
        ///- Parameter email: (required) email
        ///- Parameter username: (required) username
        fun resendActivationEmail(email : String, username : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIResendActivationEmailRequest( email,  username).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Transactions
        ///
        ///
        fun getUserTransactions(callback: (List<UserTransaction>?, HopperError?) -> Unit) {
            HopperAPIGetUserTransactionsRequest("").request<HopperAPIGetUserTransactionsResponse>({ data ->
                   callback(data.transactions,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Metadata
        ///
        ///
        fun getUserMetadata(callback: (UserMetadata?, HopperError?) -> Unit) {
            HopperAPIGetUserMetadataRequest("").request<HopperAPIGetUserMetadataResponse>({ data ->
                   callback(data.metadata,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get User Metadata
        ///
        ///
        ///- Parameter code: (required) Two factor authentication code
        fun validateTwoFactorAuth(code : String,callback: (String?, HopperError?) -> Unit) {
            HopperAPIValidateTwoFactorAuthRequest( code).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }


        // ------------- Subscription ----------------------------------------

        /// Get All User Subscriptions
        ///
        ///
        fun getAllUserSubscriptions(callback: (List<UserSubscription>?, HopperError?) -> Unit) {
            HopperAPIGetAllUserSubscriptionsRequest("").request<HopperAPIGetAllUserSubscriptionsResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get One Subscription
        ///
        ///
        ///- Parameter subscriptionId: (required) Subscription Id
        fun getOneUserSubscriptions(subscriptionId : Int, callback: (UserSubscription?, HopperError?) -> Unit) {
            HopperAPIGetOneUserSubscriptionRequest( subscriptionId).request<HopperAPIGetOneUserSubscriptionResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get All Subscription Plans
        ///
        ///
        fun getAllSubscriptionPlans(callback: (List<SubscriptionPlan>?, HopperError?) -> Unit) {
            HopperAPIGetAllSubscriptionPlansRequest("").request<HopperAPIGetAllSubscriptionPlansResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Get One Subscription Plan
        ///
        ///
        ///- Parameter planId: (required) Plan Id
        fun getOneSubscriptionPlan(planId: Int,callback: (SubscriptionPlan?, HopperError?) -> Unit) {
            HopperAPIGetOneSubscriptionPlanRequest( planId).request<HopperAPIGetOneSubscriptionPlanResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

        /// Assign Subscriotion
        ///
        ///
        ///- Parameter hopperId: (required) Hopper Id
        ///- Parameter subscriptionId: (required) Subscription Id
        fun assignSubscription(hopperId : Int, subscriptionId : Int,callback: (String?, HopperError?) -> Unit) {
            HopperAPIAssignSubscriptionRequest( hopperId,  subscriptionId).request<HopperCommonMessageResponse>({ data ->
                   callback(data.data,null)
            } ,{ error ->
                    callback(null,error)
            })
        }

    }

}