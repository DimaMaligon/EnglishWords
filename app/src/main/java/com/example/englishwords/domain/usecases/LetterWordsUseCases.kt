package com.example.englishwords.domain.usecases

import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository

class LetterWordsUseCases {
    class AddNewWordUseCase(private val englishRoomRepository: EnglishWordRepository) {
        suspend fun execute(word: Word) {
            englishRoomRepository.addNewEnglishWord(word = word)
        }
    }

    class GetEnglishListLetterUseCase (private val englishRoomRepository: EnglishWordRepository) {
        suspend fun execute(letter:String): MutableList<Word> {
            return englishRoomRepository.getEnglishListLetter(letter)
        }
    }

    class GetEnglishTranslateWordUseCase (private val englishRoomRepository: EnglishWordRepository) {
        suspend fun execute(word: String): Word {
            return englishRoomRepository.getEnglishTranslateWord(word)
        }
    }
}