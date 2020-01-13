package com.example.mbition

import android.app.Application
import com.example.mbition.di.component.DaggerMbitionComponent
import com.example.mbition.di.component.MbitionComponent
import com.example.mbition.di.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MbitionApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityDispatchingAndroidInjector

    companion object {
        @JvmStatic
        lateinit var component: MbitionComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerMbitionComponent.builder()
            .appModule(AppModule(this))
            .build()
        component.inject(this)
    }
}
