package com.example.mvpretrofit.apis

import retrofit2.Call
import com.example.mvpretrofit.data.UsersList
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    fun getUsers(@Query("q") filter: String): Call<UsersList>
}