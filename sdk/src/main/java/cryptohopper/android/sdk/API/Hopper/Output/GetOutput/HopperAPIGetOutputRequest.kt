//
//  HopperAPIGetOutputRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod
import java.text.SimpleDateFormat
import java.util.*

class HopperAPIGetOutputRequest: HopperAPIRequest<HopperAPIGetOutputResponse> {
    
    constructor(hopperId: String, dateFrom: Date, dateTo: Date, entryType: HopperSearchOptionsItemEntry, sortField: HopperSearchOptionsItemSortField, sortOrder: HopperSearchOptionsItemSortOrder, page: Int, perPage: Int) {

        this.httpMethod = HopperAPIHttpMethod.GET
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/output")

        val pattern = "MM/dd/YYYY HH:mm"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date: String = simpleDateFormat.format(Date())

        addQueryItem( "dateFrom",  simpleDateFormat.format( dateFrom))
        addQueryItem( "dateTo",  simpleDateFormat.format( dateTo))
        addQueryItem( "entryType",  entryType.rawValue)
        addQueryItem( "sortBy",  sortField.rawValue)
        addQueryItem( "sortOrder",  sortOrder.rawValue)
        addQueryItem( "offset",  page.toString())
        addQueryItem( "count",  perPage.toString())
    }
    
}
