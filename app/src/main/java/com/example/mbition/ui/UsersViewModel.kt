package com.example.mbition.ui

import androidx.lifecycle.LiveData
import com.example.mbition.base.BaseViewModel
import com.example.mbition.network.GithubRepository
import com.example.mbition.network.data.User
import javax.inject.Inject

class UsersViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : BaseViewModel() {
    fun getUserList(): LiveData<List<User>> =
        githubRepository.fetchUsers()
}
