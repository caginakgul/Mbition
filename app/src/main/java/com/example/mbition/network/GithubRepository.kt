package com.example.mbition.network

import androidx.lifecycle.LiveData
import com.example.mbition.network.data.User

interface GithubRepository {
    fun fetchUsers(): LiveData<List<User>>
}
