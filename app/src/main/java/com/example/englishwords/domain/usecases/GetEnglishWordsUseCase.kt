package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class GetEnglishWordsUseCase (private val englishRoomRepository: EnglishWordRepository) {
    suspend fun execute(): MutableList<Word> {
        return englishRoomRepository.getRandomEnglishWords()
    }
}