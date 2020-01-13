package com.example.mbition.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mbition.R
import com.example.mbition.base.BaseActivity
import com.example.mbition.network.data.User
import kotlinx.android.synthetic.main.activity_users.*
import timber.log.Timber
import javax.inject.Inject

class UsersActivity : BaseActivity(), OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UsersViewModel
    override var contentViewId = R.layout.activity_users
    private val bottomSheetTag: String = "BottomSheet"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate()")
        initBinding()
        initRecyclerView()
        fetchUsers()
    }

    override fun onItemClicked(user: User) {
        /*RepositoryDetailsBottomSheet.newInstance(repo)
            .show(supportFragmentManager, bottomSheetTag)*/
    }

    private fun fetchUsers() = viewModel.getUserList().observe(
        this,
        Observer { userList -> userList?.let { displayUsers(it) } })

    private fun initBinding() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(UsersViewModel::class.java)
    }

    private fun displayUsers(items: List<User>) {
        usersRecyclerView.adapter = UserAdapter(items, this)
    }

    private fun initRecyclerView() {
        Timber.i("RecyclerView is initialised.")
        usersRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }
}
