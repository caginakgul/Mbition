package com.example.mbition.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mbition.network.data.User
import retrofit2.Call
import retrofit2.Response
import timber.log.Timber

class GithubRepositoryImpl(
    private val api: GithubApi
) : GithubRepository {
    override fun fetchUsers(): LiveData<List<User>> {
        val liveData: MutableLiveData<List<User>> = MutableLiveData()
        api.getUsers()
            .enqueue((object : retrofit2.Callback<List<User>> {
                override fun onFailure(
                    call: Call<List<User>>?,
                    t: Throwable?
                ) {
                    Timber.e("request failed %s", t?.message)
                    liveData.value = null
                }

                override fun onResponse(
                    call: Call<List<User>>?,
                    response: Response<List<User>>?
                ) {
                    Timber.i(
                        "request successful and total size is%s",
                        response?.body()
                    )
                    liveData.value = response?.body()
                }
            }))
        return liveData
    }
}
