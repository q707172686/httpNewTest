package com.ostech.sensingTest


import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable // 1
data class Data(
    val id: Int,
    @SerialName("user_name") // 2
    val name: String = "hoge",
    @SerialName("mail_address")
    val mailAddress: String? = "" // 3
)