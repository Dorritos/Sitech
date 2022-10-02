package com.example.sitech.remote.interfaces

import com.example.sitech.remote.models.Users

interface UsersContract {
    suspend fun getUsersList() : Users
    suspend fun authorizateUser(login: String, pass: String)
}