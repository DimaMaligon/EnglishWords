package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class GetEnglishTranslateWordUseCase (private val englishRoomRepository: EnglishWordRepository) {
    suspend fun execute(word: String): Word {
        return englishRoomRepository.getEnglishTranslateWord(word)
    }
}