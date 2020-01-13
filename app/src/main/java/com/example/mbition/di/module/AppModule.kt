package com.example.mbition.di.module

import android.app.Application
import android.content.Context
import com.example.mbition.MbitionApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: MbitionApp) {
    @Provides
    @Singleton
    fun providesMbitionApp(): MbitionApp = app

    @Provides
    @Singleton
    fun providesApp(): Application = app

    @Provides
    @Singleton
    fun provideContext(): Context = app
}
