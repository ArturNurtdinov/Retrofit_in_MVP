package com.example.mvpretrofit.views

import com.example.mvpretrofit.data.UsersList

interface MainContract {
    interface Model {
        interface onFinishedDataLoading{
            fun onFinished(data: UsersList)
            fun onFailure(t: Throwable)
        }
        fun loadData()
    }

    interface Presenter {
        fun requestData()
    }

    interface View {
        fun initUI(data: UsersList)
    }
}