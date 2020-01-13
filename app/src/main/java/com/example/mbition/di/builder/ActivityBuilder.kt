package com.example.mbition.di.builder

import com.example.mbition.di.module.UsersActivityModule
import com.example.mbition.ui.UsersActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [UsersActivityModule::class])
    internal abstract fun contributeUsersActivity(): UsersActivity
}

