package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class GetEnglishListLetterUseCase (private val englishRoomRepository: EnglishWordRepository) {
    suspend fun execute(letter:String): MutableList<Word> {
        return englishRoomRepository.getEnglishListLetter(letter)
    }
}