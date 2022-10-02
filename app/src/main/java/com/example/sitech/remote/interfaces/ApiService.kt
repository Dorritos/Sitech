package com.example.sitech.remote.interfaces

import com.example.sitech.remote.models.Authorize
import com.example.sitech.remote.models.Users
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiService {

    companion object {
        const val USERS = "/{IMEI}/form/users/"
        const val AUTH = "/{IMEI}/authentication/"
    }

    @GET(USERS)
    suspend fun getUsers(
        @Query("IMEI") imei: String
    ): Users

    @GET(AUTH)
    suspend fun authorizate(
        @Query("uid") uid: UUID,
        @Query("pass") pass: String,
        @Query("copyFromDevice") copyFromDevice: Boolean,
        @Query("nfc") nfc: String = ""
    ) : Authorize

}