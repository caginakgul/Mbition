package com.example.mbition.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.mbition.base.MbitionViewModelFactory
import com.example.mbition.ui.UsersViewModel
import dagger.Module
import dagger.Provides

@Module
class UsersActivityModule {
    @Provides
    fun provideUsersViewModel(viewModel: UsersViewModel): ViewModelProvider.Factory {
        return MbitionViewModelFactory(viewModel)
    }
}
