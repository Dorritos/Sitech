package com.example.sitech.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.recyclerview.widget.RecyclerView
import com.example.sitech.R
import com.example.sitech.remote.models.Users

class UserAdapter(private val scope: LifecycleCoroutineScope) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var itemList = listOf<Users>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewUserName: TextView = view.findViewById(R.id.userName)
        val textViewUserIMEI: TextView = view.findViewById(R.id.userIMEI)
        val textViewUserLang: TextView = view.findViewById(R.id.userLanguage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
       val item = getItem(position)
        holder.apply {
            textViewUserName.text = item.Users.ListUsers.first().User
            textViewUserIMEI.text = item.Users.ListUsers.first().Uid
            textViewUserLang.text = item.Users.ListUsers.first().Language
        }
    }

    override fun getItemCount(): Int = itemList.size

    private fun getItem(position: Int): Users = itemList[position]

}