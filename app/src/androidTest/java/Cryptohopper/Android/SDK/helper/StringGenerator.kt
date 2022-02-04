package Cryptohopper.Android.SDK.helper

import kotlin.random.Random

object StringGenerator {
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    fun getRandomString(length: Int = 20): String {
        return (1..length)
            .map { _ -> Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }
}
