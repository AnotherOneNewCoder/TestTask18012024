package ru.zhogin.testtask18012024.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ServerResponse(
    @SerialName("result")
    val result: Result,
    @SerialName("retCode")
    val retCode: Int,
    @SerialName("retExtInfo")
    val retExtInfo: RetExtInfo,
    @SerialName("retMsg")
    val retMsg: String,
    @SerialName("time")
    val time: Long
)