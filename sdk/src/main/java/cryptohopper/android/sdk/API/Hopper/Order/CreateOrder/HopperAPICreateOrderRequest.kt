//
//  HopperAPICreateOrderRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 29/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPICreateOrderRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String,orderType : String,marketOrder : Int,coin : String,price : Double,amount : Double,orderTrigger : String,percentageProfit : Double,trailingBuy : Double , trailingBuyPercentage : Double) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/order")
        
        addBodyItem( "order_type", orderType)
        addBodyItem( "market_order", marketOrder)
        addBodyItem( "coin", coin)
        addBodyItem( "price",  price)
        addBodyItem( "amount",  amount)
        addBodyItem( "order_trigger",  orderTrigger)
        addBodyItem( "pct_profit",  percentageProfit)
        addBodyItem( "trailing_buy",  trailingBuy)
        addBodyItem( "trailing_buy_pct",  trailingBuyPercentage)
    }
    
}
