//
//  HopperAPIReplyMarketReviewRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod

class HopperAPIReplyMarketReviewRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(reviewId : Int ,itemId: Int,itemType : String,reviewName : String ,review:String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/market/review/$reviewId/reply")
        addBodyItem( "item_id",  itemId)
        addBodyItem( "item_type",  itemType)
        addBodyItem( "review_name",  reviewName)
        addBodyItem( "review",  review)
    }
    
}

