package com.example.mbition.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mbition.R
import com.example.mbition.network.data.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(
    private val users: List<User>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun getItemCount() = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position], itemClickListener)
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(user: User, clickListener: OnItemClickListener) {
            itemView.loginTextView.text = user.login
            itemView.setOnClickListener { clickListener.onItemClicked(user) }
        }
    }
}
