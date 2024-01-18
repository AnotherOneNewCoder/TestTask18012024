package ru.zhogin.testtask18012024.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Type(
    @SerialName("key")
    val key: String,
    @SerialName("title")
    val title: String
)