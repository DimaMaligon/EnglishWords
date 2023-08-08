package com.example.englishwords.data.repositories

import com.example.englishwords.data.Mapper
import com.example.englishwords.data.WordStorage
import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository
import java.util.stream.Collectors

class EnglishWordRepositoryImpl(val wordStorage: WordStorage, val mapper: Mapper) :
    EnglishWordRepository {
    override suspend fun getRandomEnglishWords(): MutableList<Word> {
        val listWordsStorage = wordStorage.getRandomEnglishWords()
        val listWords = listWordsStorage.stream()
            .map {
                mapper.mapFromEntity(it)
            }.collect(Collectors.toList())
        return listWords
    }

    override suspend fun getEnglishListLetter(letter: String): MutableList<Word> {
        val listWordsStorage = wordStorage.getEnglishListLetter(letter)
        val listWords = listWordsStorage.stream()
            .map {
                mapper.mapFromEntity(it)
            }.collect(Collectors.toList())
        return listWords
    }

    override suspend fun getEnglishTranslateWord(word: String): Word {
        val translateWord = wordStorage.getEnglishTranslateWord(word = word)
        return mapper.mapFromEntity(translateWord)
    }

    override suspend fun addNewEnglishWord(word: Word) {
        val englishWord = mapper.mapToEntity(word)
        wordStorage.addNewEnglishWord(word = englishWord)
    }

    override suspend fun checkCountsWords(): Int {
        return wordStorage.checkCountsWords()
    }

    override fun checkListIsEmpty(): Boolean {
        return wordStorage.checkListIsEmpty()
    }
}