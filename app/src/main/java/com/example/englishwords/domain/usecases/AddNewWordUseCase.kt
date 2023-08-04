package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class AddNewWordUseCase(private val englishRoomRepository: EnglishWordRepository) {
    suspend fun execute(word: Word) {
        englishRoomRepository.addNewEnglishWord(word = word)
    }
}