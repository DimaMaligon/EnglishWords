package com.example.englishwords.data.sources

import com.example.englishwords.data.sources.model.WordDbModel

interface WordStorage {
    suspend fun getRandomEnglishWords(): MutableList<WordDbModel>

    suspend fun getEnglishTranslateWord(word: String): WordDbModel

    suspend fun getEnglishListLetter(letter: String): MutableList<WordDbModel>

    suspend fun addNewEnglishWord(word: WordDbModel)

    suspend fun checkCountsWords(): Int

    fun checkListIsEmpty(): Boolean
}