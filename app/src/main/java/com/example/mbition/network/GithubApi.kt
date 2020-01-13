package com.example.mbition.network

import com.example.mbition.network.data.User
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("users")
    fun getUsers(): Call<List<User>>
}
