package cryptohopper.android.sdk.SharedModels.ConfigModels

//  iOS SDK
//
//  Created by Kaan Baris Bayrak on 21/10/2020.
//

import HopperError
import com.google.gson.annotations.SerializedName

data class HopperAPIError(
        @SerializedName("error") val errCode: Int?,
        @SerializedName("message") val errMessage: String?,
        @SerializedName("status") val status: Int?,
        @SerializedName("code") val code: Int?
){
    var error : HopperError? = HopperError.UNKOWN_ERROR
        get()  {
            return when(this.errCode){
                400 -> HopperError.BAD_REQUEST
                401 -> HopperError.UNAUTHORIZED
                403 -> HopperError.ENDPOINT_FORBIDDEN
                404 -> HopperError.ENDPOINT_NOT_FOUND
                405 -> HopperError.ENDPOINT_NOT_ALLOWED
                429 -> HopperError.API_LIMIT_EXCEED
                500 -> HopperError.SERVER_ERROR
                503 -> HopperError.SERVICE_UNAVAILABLE
                else -> HopperError.UNKOWN_ERROR
            }
        }
}
