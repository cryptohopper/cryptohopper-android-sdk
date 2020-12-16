import com.google.gson.annotations.SerializedName

data class HopperReserved (
        @SerializedName("id") val id: String?,
        @SerializedName("pair") val pair: String?,
        @SerializedName("exchange") val exchange: String?,
        @SerializedName("currency") val currency: String?,
        @SerializedName("amount") val amount: String?,
        @SerializedName("rate") val rate: String?,
        @SerializedName("val") val value: String?,
        @SerializedName("btc") val btc: String?,
        @SerializedName("sell_time") val sellTime: String?,
        @SerializedName("buy_time") val buyTime: String?,
        @SerializedName("base") val base: String?
)