//
//  HopperAPIGetOutputRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod
import java.text.SimpleDateFormat
import java.util.*

class HopperAPIGetOutputRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId: String, dateFrom: Date, dateTo: Date, entryType: HopperSearchOptionsItemEntry, sortField: HopperSearchOptionsItemSortField, sortOrder: HopperSearchOptionsItemSortOrder, page: Int, perPage: Int) {

        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/output")

        val pattern = "Y-m-d H:m:s"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date: String = simpleDateFormat.format(Date())
        println(date)

        var options  = mutableMapOf<String,Any>()
        options["date_from"] = simpleDateFormat.format(dateFrom)
        options["date_to"] = simpleDateFormat.format(dateTo)
        options["entry_type"] = entryType.rawValue
        options["sort_field"] = sortField.rawValue
        options["sort_order"] = sortOrder.rawValue
        options["page"] = page
        options["perPage"] = perPage
        addBodyItem("search_opts", options)
    }
    
}
