package com.example.mbition.di.component

import com.example.mbition.MbitionApp
import com.example.mbition.di.builder.ActivityBuilder
import com.example.mbition.di.module.ApiModule
import com.example.mbition.di.module.AppModule
import com.example.mbition.di.module.DataRepositoryModule
import com.example.mbition.di.module.HttpModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        HttpModule::class,
        DataRepositoryModule::class,
        ApiModule::class
    ]
)
interface MbitionComponent {
    fun inject(app: MbitionApp)
}
