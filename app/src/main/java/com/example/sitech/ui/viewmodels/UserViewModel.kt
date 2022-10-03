package com.example.sitech.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sitech.remote.interfaces.UsersContract
import com.example.sitech.remote.models.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userContract: UsersContract) : ViewModel() {

    val usersFlow = MutableStateFlow<Users?>(null)

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userContract.getUsersList()
            usersFlow.emit(user)
        }
    }

}