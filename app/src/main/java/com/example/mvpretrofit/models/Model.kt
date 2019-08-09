package com.example.mvpretrofit.models

import android.util.Log
import com.example.mvpretrofit.data.Api
import com.example.mvpretrofit.data.UsersList
import com.example.mvpretrofit.views.MainActivity
import com.example.mvpretrofit.views.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Model(private val setData: MainContract.Model.onFinishedDataLoading) : MainContract.Model {
    private val BASE_URL = "https://api.github.com/search/"
    override fun loadData() {
        val retorift = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val call = retorift.create(Api::class.java)
        call.getUsers("rokano").enqueue(object : Callback<UsersList> {
            override fun onFailure(call: Call<UsersList>, t: Throwable) {
                Log.d(MainActivity.MVP_TAG, "Failed to load")
                setData.onFailure(t)
            }

            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                Log.d(MainActivity.MVP_TAG, "Model loads data")
                setData.onFinished(response.body()!!)
            }

        })
    }
}