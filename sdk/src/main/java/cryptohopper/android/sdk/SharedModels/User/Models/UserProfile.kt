//
//  UserProfile.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName

data class UserProfile (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("website") val website: String?,
    @SerializedName("region") val region: String?,
    @SerializedName("postal_code") val postalCode: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("address1") val addressOne: String?,
    @SerializedName("address2") val addressTwo: String?,
    @SerializedName("enabled_2fa") val enableTwoFactorAuth: Boolean?
)
