package com.example.englishwords.db

import android.provider.BaseColumns

object MyDataBase: BaseColumns {
    const val TABLE_NAME_LETTER = "letter_table"
    const val TABLE_NAME_WORDS = "words_table"
    const val LETTER = "letter"
    const val WORDS_OF_LETTER = "words"
    const val TRANSLATE_OF_WORD = "transcription"
    const val LETTER_WORDS = "letter_words"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Myletters.db"

    const val SQL_CREATE_TABLE_LETTER = "CREATE TABLE $TABLE_NAME_LETTER (" +
    "${BaseColumns._ID} INTEGER," +
            "$LETTER TEXT PRIMARY KEY)"

    const val SQL_DELETE_TABLE_LETTER = "DROP TABLE IF EXISTS $TABLE_NAME_LETTER"

    const val SQL_CREATE_TABLE_WORDS = "CREATE TABLE $TABLE_NAME_WORDS (" +
            "${BaseColumns._ID} INTEGER," +
            "$WORDS_OF_LETTER TEXT," +
            "$TRANSLATE_OF_WORD TEXT," +
            "$LETTER_WORDS TEXT," +
            "FOREIGN KEY($LETTER_WORDS) REFERENCES $TABLE_NAME_LETTER($LETTER))"

    const val SQL_DELETE_TABLE_WORDS = "DROP TABLE IF EXISTS $TABLE_NAME_WORDS"
}