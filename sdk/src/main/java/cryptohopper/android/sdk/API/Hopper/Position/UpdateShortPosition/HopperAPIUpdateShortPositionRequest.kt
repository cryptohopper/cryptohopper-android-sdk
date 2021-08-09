//
//  HopperAPIUpdateMultiplePositionsRequest.swift
//  Cryptohopper-iOS-SDK
//
//  Created by Kaan Baris Bayrak on 02/11/2020.
//

import cryptohopper.android.sdk.SharedModels.ConfigModels.HopperAPIHttpMethod


class HopperAPIUpdateShortPositionRequest: HopperAPIRequest<HopperCommonMessageResponse> {
    
    constructor(hopperId : String , shortId:Int , takeProfit : Double,trailingStopLoss : Int, trailingStopLossPercentage : Double,trailingStopLossArm : Double,autoCloseTime : String,autoRemoveTime : String) {
        this.httpMethod = HopperAPIHttpMethod.POST
        this.needsAuthentication = true
        this.changeUrlPath("/hopper/$hopperId/setshortsetting")
        addBodyItem( "take_profit", takeProfit)

        addBodyItem( "trailing_enabled", trailingStopLoss)
        if(trailingStopLoss == 1){
            addBodyItem( "trailing_percentage", trailingStopLossPercentage)
            addBodyItem( "trailing_arm_percentage", trailingStopLossArm)
        }

        addBodyItem( "auto_close_time", autoCloseTime)
        addBodyItem( "auto_remove_time",  autoRemoveTime)
    }
    
}
