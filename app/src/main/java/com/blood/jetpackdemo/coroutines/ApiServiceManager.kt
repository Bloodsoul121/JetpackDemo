package com.blood.jetpackdemo.coroutines

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object ApiServiceManager {
    private val retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS).build())
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val apiService = retrofit.create<Api>()
}