package com.englishwords.data.sources.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.englishwords.data.model.WordDbModel
import com.englishwords.data.sources.room.dao.WordDaoRoom

@Database(entities = [WordDbModel::class], version = 1)
abstract class DataBaseWord : RoomDatabase() {
    abstract fun wordDao(): WordDaoRoom
}