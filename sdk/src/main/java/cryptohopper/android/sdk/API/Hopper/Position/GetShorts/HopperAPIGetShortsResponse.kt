import com.google.gson.annotations.SerializedName

data class HopperAPIGetShortsResponse (
        @SerializedName("data") val data: List<HopperShortPosition>?
)