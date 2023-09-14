package com.example.englishwords.data

interface DaoSource<T> {
    suspend fun insertToWords(type: T)

    suspend fun checkWordsTable(): Int

    fun checkIsEmpty(): Boolean

    suspend fun readWordsLetter(letterScreen: String): MutableList<T>

    suspend fun readRandomWords(): MutableList<T>

    suspend fun searchWord(wordSearch: String): T
}