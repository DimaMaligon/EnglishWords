package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.repository.EnglishWordRepository

class CheckListWordsIsEmptyUseCase (private val englishRoomRepository: EnglishWordRepository) {
    fun execute(): Boolean {
        return englishRoomRepository.checkListIsEmpty()
    }
}