package com.example.mbition.di.module

import com.example.mbition.network.GithubApi
import com.example.mbition.network.GithubRepository
import com.example.mbition.network.GithubRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataRepositoryModule {
    @Provides
    @Singleton
    fun provideGithubRepository(
        githubApi: GithubApi
    ): GithubRepository = GithubRepositoryImpl(githubApi)
}
