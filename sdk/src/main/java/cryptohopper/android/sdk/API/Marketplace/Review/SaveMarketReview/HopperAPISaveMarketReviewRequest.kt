//
//  HopperAPISaveMarketReviewRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPISaveMarketReviewRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(marketplaceId : Int,marketItemType : String,reviewName : String,review : String ,rating:Int , replyTo : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/market/savereview")
        addBodyItem( "marketplace_item_id", marketplaceId)
        addBodyItem( "market_item_type",  marketItemType)
        addBodyItem( "review_name",  reviewName)
        addBodyItem( "review",  review)
        addBodyItem( "rating",  rating)
        addBodyItem( "reply_to",  replyTo)
    }
    
}
