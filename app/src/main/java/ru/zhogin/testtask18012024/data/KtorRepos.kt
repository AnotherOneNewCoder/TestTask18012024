package ru.zhogin.testtask18012024.data

import ru.zhogin.testtask18012024.data.models.ListServer

interface KtorRepos {
    suspend fun getResult(): Resource<List<ListServer>>
}