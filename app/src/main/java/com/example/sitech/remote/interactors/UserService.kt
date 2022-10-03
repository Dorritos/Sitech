package com.example.sitech.remote.interactors

import com.example.sitech.remote.interfaces.ApiService
import com.example.sitech.remote.interfaces.UsersContract
import com.example.sitech.remote.models.Authorize
import com.example.sitech.remote.models.Users
import com.example.sitech.utils.ImeiUtil

class UserService(private val api: ApiService) : UsersContract {

    override suspend fun getUsersList(): Users {
        return api.getUsers(ImeiUtil.imei)
    }

    override suspend fun authorizateUser(login: String, pass: String): Authorize {
        return api.authorizate(ImeiUtil.imei, pass, false, "")
    }

}