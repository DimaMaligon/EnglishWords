package com.example.englishwords.domain.repository

import com.example.englishwords.domain.models.Word


interface EnglishWordRepository {
 suspend fun getRandomEnglishWords(): MutableList<Word>

 suspend fun getEnglishTranslateWord(word: String): Word

 suspend fun getEnglishListLetter(letter: String): MutableList<Word>

 suspend fun addNewEnglishWord(word: Word)

 suspend fun checkCountsWords(): Int

 fun checkListIsEmpty(): Boolean
}