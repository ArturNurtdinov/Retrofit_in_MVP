package com.example.mvpretrofit.presenters

import android.util.Log
import com.example.mvpretrofit.data.UsersList
import com.example.mvpretrofit.models.Model
import com.example.mvpretrofit.views.MainActivity
import com.example.mvpretrofit.views.MainContract

class Presenter(private val view: MainContract.View) : MainContract.Presenter, MainContract.Model.OnDataLoading {
    private val model = Model(this)

    override fun requestData() {
        Log.d(MainActivity.MVP_TAG, "Data requested")
        model.loadData()
    }

    override fun onLoaded(data: UsersList) {
        Log.d(MainActivity.MVP_TAG, "Data passed to View")
        view.initUI(data)
    }

    override fun onFailure(t: Throwable) {
        t.printStackTrace()
    }}