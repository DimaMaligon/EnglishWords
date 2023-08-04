package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.repository.EnglishWordRepository

class CheckCountsWordsUseCase(private val englishRoomRepository: EnglishWordRepository) {
    suspend fun execute(): Int {
        return englishRoomRepository.checkCountsWords()
    }
}