//
//  HopperAPIUpdateMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateShortPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , shortId:Int , takeProfit : Int,stopLoss : Int,stopLossPercentage : Int,trailingStopLoss : Int, trailingStopLossPercentage : Int,trailingStopLossArm : Int,autoClose : Int,autoCloseTime : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/short/$shortId/update")
        addBodyItem( "take_profit", takeProfit)
        addBodyItem( "stop_loss", stopLoss)
        addBodyItem( "stop_loss_percentage", stopLossPercentage)
        addBodyItem( "trailing_stop_loss", trailingStopLoss)
        addBodyItem( "trailing_stop_loss_percentage", trailingStopLossPercentage)
        addBodyItem( "trailing_stop_loss_arm", trailingStopLossArm)
        addBodyItem( "auto_close", autoClose)
        addBodyItem( "auto_close_time", autoCloseTime)
    }
    
}
