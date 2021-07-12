package cryptohopper.android.sdk.API.Hopper.Stats.GetStats

import com.google.gson.annotations.SerializedName
import java.util.*

data class HopperAPIGetHopperStatsResponse (
        @SerializedName("data") val data: HopperStats?
)

data class HopperStats (
        @SerializedName("date_range") val dateRange: Boolean?,
        @SerializedName("start_time") val startTime: Int?,
        @SerializedName("end_time") val endTime: Int?,
        @SerializedName("buysandsells") val buysSells: Object?,
        @SerializedName("mosttraded") val mostTraded: Map<String,Int>?,
        @SerializedName("average_holding_time") val averageHoldingTime: Map<String,Double>?,
        @SerializedName("average_profit") val averageProfit: Map<String,Double>?,
        @SerializedName("profits_sell_triggers") val profitSellTriggers: Map<String,Double>?,
        @SerializedName("profits_sell_triggers_total") val profitSellTriggersTotal: Int?,
        @SerializedName("profits_sell_triggers_counts") val profitSellTriggersCounts: Map<String,Int>?,
        @SerializedName("profits_buy_triggers") val profitBuyTriggers: Map<String,Double>?,
        @SerializedName("profits_buy_triggers_total") val profitBuyTriggersTotal: Int?,
        @SerializedName("profits_buy_triggers_counts") val profitBuyTriggersCounts: Map<String,Int>?,
        @SerializedName("daily_profits") val dailyProfits: List<List<Double>>?,
        @SerializedName("allocation_of_funds") val allocationOfFunds: Map<String,Object>?,
        @SerializedName("currentinassets") val currentInAssets: List<List<Object>>?,
        @SerializedName("currentusdinassets") val currentUsdInAssets: List<List<Object>>?,
        @SerializedName("average_profit_total") val averageProfitTotal: Double?,
        @SerializedName("average_holding_time_total") val averageHoldingTimeTotal: Double?,
        @SerializedName("totaltraded") val totalTraded: Int?,
        @SerializedName("profitstats") val profitStats: Map<String,String>?,
        @SerializedName("assets") val assets: Map<String,Double>?,
        @SerializedName("stats_open_positions") val statsOpenPositions: HopperStatsOpenPosition?
)

data class HopperStatsOpenPosition (
        @SerializedName("per_cur_totals") val perCurrencyTotal: Map<String,Map<String,String>>?,
        @SerializedName("other_coins") val otherCoins: List<String>?,
        @SerializedName("data") val data: List<HopperStatsOpenPositionData>?,
        @SerializedName("total_costs") val totalCost: String?,
        @SerializedName("average_perc") val averagePercentage: Object?,
        @SerializedName("average_hold") val averageHold: String?,
        @SerializedName("total_pos") val totalPositions: Int?
)

data class HopperStatsOpenPositionData (
        @SerializedName("label") val label: String?,
        @SerializedName("data") val data: Double?
)