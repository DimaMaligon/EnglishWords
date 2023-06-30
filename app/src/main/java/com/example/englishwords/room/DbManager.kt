package com.example.englishwords.room

import android.app.Application
import androidx.room.Room
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbManager @Inject constructor(val application: Application) {
    lateinit var db: DataBaseWord

    fun openDb() {
        db = Room.databaseBuilder(
            application,
            DataBaseWord::class.java,
            "words.db"
        ).build()
    }

    fun getDao(): WordDao {
        return db.wordDao()
    }
}