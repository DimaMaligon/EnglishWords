package com.example.englishwords.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Word::class], version = 1)
abstract class DataBaseWord : RoomDatabase() {
    abstract fun wordDao(): WordDao
}