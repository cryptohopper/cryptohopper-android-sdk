import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.TAValue

data class HopperShortPosition(
    @SerializedName("id") val id: String?,
    @SerializedName("pair") val pair: String?,
    @SerializedName("exchange") val exchange: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("amount") val amount: String?,
    @SerializedName("rate") val rate: String?,
    @SerializedName("val") val value: String?,
    @SerializedName("btc") val btc: String?,
    @SerializedName("start_profit") val startProfit: String?,
    @SerializedName("start_rate") val startRate: String?,
    @SerializedName("buy_trigger") val buyTrigger: String?,
    @SerializedName("sell_trigger") val sellTrigger: String?,
    @SerializedName("percentage_profit") val percentageProfit: String?,
    @SerializedName("ta_values") val taValue: TAValue?,
    @SerializedName("sell_rate") val sellRate: String?,
    @SerializedName("sell_time") val sellTime: String?,
    @SerializedName("buy_time") val buyTime: String?,
    @SerializedName("buy_rate") val buyRate: String?,
    @SerializedName("stop_loss") val stopLoss: String?,
    @SerializedName("stop_loss_percentage") val stopLossPercentage: String?,
    @SerializedName("trailing_percentage") val trailingPercentage: String?,
    @SerializedName("trailing_arm") val trailingArm: String?,
    @SerializedName("trailing_arm_percentage") val trailingArmPercentage: String?,
    @SerializedName("auto_close_time") val autoCloseTime: String?,
    @SerializedName("auto_remove_time") val autoRemoveTime: String?,
    @SerializedName("hold") val hold: String?,
    @SerializedName("trailing_stop_loss_enabled") val trailingStopLossEnabled: String?,
    @SerializedName("trailing_stop_loss_only") val trailingStopLossOnly: String?,
    @SerializedName("stop_loss_enabled") val stopLossEnabled: String?,
    @SerializedName("auto_close_enabled") val autoCloseEnabled: String?,
    @SerializedName("auto_remove_enabled") val autoRemoveEnabled: String?

)