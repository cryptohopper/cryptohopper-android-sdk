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
        this.changeUrlPath("/hopper/$hopperId/position/setpositionsetting")
        addBodyItem( "take_profit", takeProfit)
        addBodyItem( "stop_loss_enabled", stopLoss)
        if(stopLoss == 1){
            addBodyItem( "stop_loss_percentage",  stopLossPercentage)
        }

        addBodyItem( "trailing_enabled",  trailingStopLoss)
        if(trailingStopLoss == 1){
            addBodyItem( "trailing_percentage",  trailingStopLossPercentage)
            addBodyItem( "trailing_arm_percentage",  trailingStopLossArm)
        }

        addBodyItem( "auto_close",  autoClose)
        addBodyItem( "auto_close_time",  autoCloseTime)
    }
    
}
