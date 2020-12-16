import com.google.gson.annotations.SerializedName

data class HopperAPIGetReservedPositionsResponse (
        @SerializedName("data") val data: List<HopperReserved>?
)