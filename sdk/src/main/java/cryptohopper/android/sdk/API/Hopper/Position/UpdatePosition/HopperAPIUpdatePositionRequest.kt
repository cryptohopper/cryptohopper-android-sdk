//
//  HopperAPIUpdatePositionRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 30/10/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdatePositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , positionId:Int,takeProfit : Double,trailingStopLoss : Int, trailingStopLossPercentage : Double,trailingStopLossArm : Double,autoClose : Int,autoCloseTime : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/position/setpositionsetting")
        addBodyItem( "take_profit", takeProfit)

        addBodyItem( "trailing_enabled",  trailingStopLoss)
        if(trailingStopLoss == 1){
            addBodyItem( "trailing_percentage",  trailingStopLossPercentage)
            addBodyItem( "trailing_arm_percentage",  trailingStopLossArm)
        }

        addBodyItem( "auto_close",  autoClose)
        addBodyItem( "auto_close_time",  autoCloseTime)
    }
    
}
