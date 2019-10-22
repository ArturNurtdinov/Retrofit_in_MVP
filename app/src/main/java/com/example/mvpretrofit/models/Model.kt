package com.example.mvpretrofit.models

import android.util.Log
import com.example.mvpretrofit.data.Api
import com.example.mvpretrofit.views.MainActivity
import com.example.mvpretrofit.views.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Model(private val onDataLoading: MainContract.OnDataLoading) : MainContract.Model {
    private val BASE_URL = "https://api.github.com/search/"
    override fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val listObservable = retrofit.create(Api::class.java).getUsers("rokano")
        listObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(MainActivity.MVP_TAG, "${it.body()?.users}")
                onDataLoading.onLoaded(it.body()!!)
            }, {
                it.printStackTrace()
            })
    }
}