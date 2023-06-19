package kr.co.bullets.part2chapter3r

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("message")
    val message: String
)
