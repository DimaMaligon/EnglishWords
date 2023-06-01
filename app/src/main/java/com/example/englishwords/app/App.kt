package com.example.englishwords.app

import android.app.Application
import com.example.englishwords.db.MyDbManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var myDbManager: MyDbManager

    override fun onCreate() {
        super.onCreate()
        myDbManager.openDb()
    }
}