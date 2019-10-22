package com.example.mvpretrofit.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("users")
    fun getUsers(@Query("q") filter: String): Single<Response<UsersList>>
}