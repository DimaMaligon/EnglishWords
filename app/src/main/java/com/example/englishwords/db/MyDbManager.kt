package com.example.englishwords.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class MyDbManager(context: Context) {
    val myDbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = myDbHelper.writableDatabase
    }

    fun insertToWordsTable(letter: String, word: String, translate: String) {
        val valuesSet = ContentValues().apply {
            put(MyDataBase.LETTER_WORDS, letter)
            put(MyDataBase.WORDS_OF_LETTER, word)
            put(MyDataBase.TRANSLATE_OF_WORD, translate)
        }
        db?.insert(MyDataBase.TABLE_NAME_WORDS, null, valuesSet)
    }

    fun insertToLetterTable(letter: String) {
        val valuesSet = ContentValues().apply {
            put(MyDataBase.LETTER, letter)
        }
        db?.insert(MyDataBase.TABLE_NAME_LETTER, null, valuesSet)
    }

    @SuppressLint("Range")
    fun readWordsTable(letter: String): ArrayList<String> {
        val dataList = ArrayList<String>()

        val cursor = db?.query(
            MyDataBase.TABLE_NAME_WORDS,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            "letter_words = '$letter'",   // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        with(cursor) {
            while (this?.moveToNext()!!) {
                val dataWord = getString(getColumnIndex(MyDataBase.WORDS_OF_LETTER))
                val dataTranslate = getString(getColumnIndex(MyDataBase.TRANSLATE_OF_WORD))
                dataList.add("$dataWord - $dataTranslate")
            }
        }
        cursor?.close()
        return dataList
    }

    fun closeDb() {
        myDbHelper.close()
    }
}