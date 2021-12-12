package Cryptohopper.Android.SDK.helper

import android.os.SystemClock
import java.util.concurrent.TimeUnit

object TimeLapsCalculator {

    val estimatedAPiResponseTime = TimeUnit.MILLISECONDS.toSeconds(5000)
    var apiCallerStartTime = 0L

    fun startTimer() {
        apiCallerStartTime = SystemClock.elapsedRealtime()
    }

    fun resetTimer() {
        apiCallerStartTime = 0L
    }

    fun getApiResponseTime(): Long {
        return TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - apiCallerStartTime)
    }
}
