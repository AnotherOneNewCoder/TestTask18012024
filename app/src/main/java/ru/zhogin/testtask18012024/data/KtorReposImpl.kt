package ru.zhogin.testtask18012024.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import ru.zhogin.testtask18012024.data.models.ListServer
import ru.zhogin.testtask18012024.data.models.ServerResponse
import ru.zhogin.testtask18012024.data.network.BASE_URL
import javax.inject.Inject


class KtorReposImpl @Inject constructor(
    private val httpClient: HttpClient
) : KtorRepos {
    override suspend fun getResult(): Resource<List<ListServer>> {
        return try {
            Resource.Success(
                httpClient.get<ServerResponse> {
                    url(BASE_URL)
                }.result.list
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}