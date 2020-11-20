//
//  HopperAPIUpdatePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdatePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId:Int,takeProfit : Int,stopLoss : Int,stopLossPercentage : Int,trailingStopLoss : Int, trailingStopLossPercentage : Int,trailingStopLossArm : Int,autoClose : Int,autoCloseTime : Int) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/$positionId/update")
        addBodyItem( "take_profit", takeProfit)
        addBodyItem( "stop_loss", stopLoss)
        addBodyItem( "stop_loss_percentage",  stopLossPercentage)
        addBodyItem( "trailing_stop_loss",  trailingStopLoss)
        addBodyItem( "trailing_stop_loss_percentage",  trailingStopLossPercentage)
        addBodyItem( "trailing_stop_loss_arm",  trailingStopLossArm)
        addBodyItem( "auto_close",  autoClose)
        addBodyItem( "auto_close_time",  autoCloseTime)
    }
    
}
