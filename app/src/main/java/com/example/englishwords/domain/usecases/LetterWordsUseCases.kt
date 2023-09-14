package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class LetterWordsUseCases(val englishRoomRepository: EnglishWordRepository) {
    inner class AddNewWordUseCase {
        suspend fun execute(word: Word) {
            englishRoomRepository.addNewEnglishWord(word = word)
        }
    }

    inner class GetEnglishListLetterUseCase {
        suspend fun execute(letter:String): List<Word> {
            return englishRoomRepository.getEnglishListLetter(letter)
        }
    }

    inner class GetEnglishTranslateWordUseCase {
        suspend fun execute(word: String): Word {
            return englishRoomRepository.getEnglishTranslateWord(word)
        }
    }
}