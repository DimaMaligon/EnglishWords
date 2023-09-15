package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class RepeatWordsUseCases {
    class GetEnglishWordsUseCase (private val englishRoomRepository: EnglishWordRepository) {
        suspend fun execute(): MutableList<Word> {
            return englishRoomRepository.getRandomEnglishWords()
        }
    }

    class CheckListWordsIsEmptyUseCase (private val englishRoomRepository: EnglishWordRepository) {
        fun execute(): Boolean {
            return englishRoomRepository.checkListIsEmpty()
        }
    }

    class CheckCountsWordsUseCase(private val englishRoomRepository: EnglishWordRepository) {
        suspend fun execute(): Int {
            return englishRoomRepository.checkCountsWords()
        }
    }
}