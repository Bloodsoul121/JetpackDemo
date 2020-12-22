package com.blood.jetpackdemo.coroutines

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface Api {

    @POST("user/login")
    suspend fun login(@Field("username") username: String, @Field("password") password: String): Call<Result<User>>

}