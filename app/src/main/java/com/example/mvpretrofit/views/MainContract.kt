package com.example.mvpretrofit.views

import com.example.mvpretrofit.data.UsersList

interface MainContract {
    interface Model {
        fun loadData()
    }

    interface Presenter {
        fun requestData()
    }

    interface View {
        fun initUI(data: UsersList)
    }

    interface OnDataLoading {
        fun onLoaded(data: UsersList)
        fun onFailure(t: Throwable)
    }
}