package com.example.englishwords.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context :Context) : SQLiteOpenHelper(context, MyDataBase.DATABASE_NAME, null, MyDataBase.DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyDataBase.SQL_CREATE_TABLE_WORDS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(MyDataBase.SQL_DELETE_TABLE_WORDS)
        onCreate(db)
    }
}