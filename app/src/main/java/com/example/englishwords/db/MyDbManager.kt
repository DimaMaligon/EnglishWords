package com.example.englishwords.db

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyDbManager @Inject constructor(application: Application) {
    val myDbHelper = DbHelper(application)
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

    @SuppressLint("Range")
    fun readWordsTable(letter: String?): ArrayList<String> {
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

    @SuppressLint("Range")
    fun readRandomWordsTable(): HashMap<String, String> {
        val dataMap = HashMap<String, String>()

        val cursor = db?.query(
            MyDataBase.TABLE_NAME_WORDS,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,   // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            "RANDOM() LIMIT 4"            // The sort order
        )
        with(cursor) {
            while (this?.moveToNext() == true) {
                val dataWord = getString(getColumnIndex(MyDataBase.WORDS_OF_LETTER))
                val dataTranslate = getString(getColumnIndex(MyDataBase.TRANSLATE_OF_WORD))
                dataMap[dataWord] = dataTranslate
            }
        }
        cursor?.close()
        return dataMap
    }

    fun closeDb() {
        myDbHelper.close()
    }
}