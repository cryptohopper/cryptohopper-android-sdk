//
//  UserNotification.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 03/11/2020.
//

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserNotification (
    @SerializedName("id") val id: String?,
    @SerializedName("message_type") val messageType: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("extra_data") val extraData: String?,
    @SerializedName("date") val date: String?
)

