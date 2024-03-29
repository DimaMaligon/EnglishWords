package com.englishwords.domain.usecases

import com.englishwords.domain.models.Word
import com.englishwords.domain.repository.EnglishWordRepository

class RepeatWordsUseCases(val englishRoomRepository: EnglishWordRepository) {

    inner class GetEnglishWordsUseCase {
        suspend fun execute(): List<Word> {
            return englishRoomRepository.getRandomEnglishWords()
        }
    }

    inner class CheckListWordsIsEmptyUseCase {
        fun execute(): Boolean {
            return englishRoomRepository.checkListIsEmpty()
        }
    }

    inner class CheckCountsWordsUseCase {
        suspend fun execute(): Int {
            return englishRoomRepository.checkCountsWords()
        }
    }
}