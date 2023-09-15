package com.example.englishwords.data.sources.room.db

import android.app.Application
import androidx.room.Room
import com.example.englishwords.data.sources.room.dao.WordDao
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