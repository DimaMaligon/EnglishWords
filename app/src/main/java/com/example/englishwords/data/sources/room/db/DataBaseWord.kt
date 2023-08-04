package com.example.englishwords.data.sources.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.englishwords.data.sources.model.WordDbModel
import com.example.englishwords.data.sources.room.dao.WordDao

@Database(entities = [WordDbModel::class], version = 1)
abstract class DataBaseWord : RoomDatabase() {
    abstract fun wordDao(): WordDao
}