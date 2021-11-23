package cryptohopper.android.sdk.utils

import kotlin.random.Random

object StringGenerator {
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun getRandomString(length: Int): String {
        return (1..length)
            .map { i -> Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }
}
