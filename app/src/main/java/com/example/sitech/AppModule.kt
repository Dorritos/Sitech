package com.example.sitech

import com.example.sitech.remote.interfaces.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://dev.sitec24.ru/UKA_TRADE/"

val appModule = module {

    single { Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }

    single { get<Retrofit>().create(ApiService::class.java) }

}