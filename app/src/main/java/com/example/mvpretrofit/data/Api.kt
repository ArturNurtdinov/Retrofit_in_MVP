package com.example.mvpretrofit.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    fun getUsers(@Query("q") filter: String): Call<UsersList>
}