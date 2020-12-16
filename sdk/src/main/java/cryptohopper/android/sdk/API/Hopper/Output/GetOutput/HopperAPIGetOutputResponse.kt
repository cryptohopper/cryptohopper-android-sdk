import com.google.gson.annotations.SerializedName
import cryptohopper.android.sdk.SharedModels.Hopper.Models.HopperOutput

data class HopperAPIGetOutputResponse (
        @SerializedName("data") val data: List<HopperOutput>?
)

