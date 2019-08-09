package com.example.mvpretrofit.views

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.example.mvpretrofit.R
import com.example.mvpretrofit.data.UsersList
import com.example.mvpretrofit.presenters.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private val presenter = Presenter(this)

    companion object {
        private const val REQUEST_CODE = 1
        const val MVP_TAG = "MVP_TAG"
    }

    override fun initUI(data: UsersList) {
        Log.d(MVP_TAG, "Data set im UI")
        data.users?.forEach {
            text_view.text = "${text_view.text} '\n' " +
                    "${it.login} ${it.id} ${it.score}"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.INTERNET),
                REQUEST_CODE
            )
        }
        presenter.requestData()
    }
}
