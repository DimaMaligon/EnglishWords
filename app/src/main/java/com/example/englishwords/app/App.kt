package com.example.englishwords.app

import android.app.Application
import com.example.englishwords.data.sources.room.db.DbManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var dbManager: DbManager

    override fun onCreate() {
        super.onCreate()
        dbManager.openDb()
    }
}