package ru.zhogin.testtask18012024.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.zhogin.testtask18012024.data.KtorRepos
import ru.zhogin.testtask18012024.data.KtorReposImpl
import ru.zhogin.testtask18012024.data.network.HttpClient

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: HttpClient): io.ktor.client.HttpClient = httpClient.getHttpClient()

    @Provides
    fun getRepos(impl: KtorReposImpl): KtorRepos = impl
}