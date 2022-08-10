//
//  HopperAPIConfiguration.swift
//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import android.content.Context
import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIEnvironment

class HopperAPIConfiguration {
    var context: Context? = null
    var environment: HopperAPIEnvironment = HopperAPIEnvironment.Production
    var debugModeEnabled: Boolean = false
    var clientId: String? = null
    var isAuthenticationRequest = false
    var authenticationHost: String = "app-aws-useast1.cryptohopper.com"
    var v2ApiValidationKey: String = ""
    var v2ApiValidationValue: String = ""

    val host: String
        get() {
            return when (environment) {
                HopperAPIEnvironment.Sandbox -> "api.cryptohopper.com/v1"
                HopperAPIEnvironment.Production -> "api.cryptohopper.com/v1"
            }
        }

    val v2Host: String
        get() {
            return when (environment) {
                HopperAPIEnvironment.Sandbox -> "www-dev.cryptohopper.com"//"www-dev.cryptohopper.com/rest/api/v2"
                HopperAPIEnvironment.Production -> "www.cryptohopper.com/rest/api/v2"
            }
        }

    val urlScheme: String
        get() {
            return when (environment) {
                HopperAPIEnvironment.Sandbox -> "https"
                HopperAPIEnvironment.Production -> "https"
            }
        }

}
