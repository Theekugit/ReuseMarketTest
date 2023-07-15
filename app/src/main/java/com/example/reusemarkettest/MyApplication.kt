package com.example.reusemarkettest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

    companion object{
        lateinit var myApp: MyApplication
        fun getApp() = myApp
    }
    override fun onCreate() {
        super.onCreate()
        myApp = this
    }
}