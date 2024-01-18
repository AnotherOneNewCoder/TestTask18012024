package ru.zhogin.testtask18012024.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Result(
    @SerialName("list")
    val list: List<ListServer>,
    @SerialName("total")
    val total: Int
)