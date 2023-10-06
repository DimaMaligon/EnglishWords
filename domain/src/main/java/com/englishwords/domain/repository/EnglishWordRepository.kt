package com.englishwords.domain.repository

import com.englishwords.domain.models.Word


interface EnglishWordRepository {
 suspend fun getRandomEnglishWords(): List<Word>

 suspend fun getEnglishTranslateWord(word: String): Word

 suspend fun getEnglishListLetter(letter: String): List<Word>

 suspend fun addNewEnglishWord(word: Word)

 suspend fun checkCountsWords(): Int

 fun checkListIsEmpty(): Boolean
}