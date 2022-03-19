package com.itacademy.alertdialogapp

import android.app.Application
import com.itacademy.alertdialogapp.services.Api
import com.itacademy.alertdialogapp.services.RetrofitClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        service = RetrofitClient.getClient().create(Api::class.java)
    }

    companion object{
        var service: Api? = null
    }
}