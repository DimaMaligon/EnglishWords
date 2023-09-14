package com.example.englishwords.data.repositories

import com.example.englishwords.data.DaoSource
import com.example.englishwords.data.Mapper
import com.example.englishwords.data.model.WordDbModel
import com.example.englishwords.domain.models.Word
import com.example.englishwords.domain.repository.EnglishWordRepository
import javax.inject.Inject

class EnglishWordRepositoryImpl @Inject constructor(
    private val source: DaoSource<WordDbModel>, private val mapper: Mapper
) : EnglishWordRepository {
    override suspend fun getRandomEnglishWords(): List<Word> {
        return source.readRandomWords().map {
                mapper.mapToDomain(it)
            }
    }

    override suspend fun getEnglishTranslateWord(word: String): Word {
        return source.searchWord(word).let {
            mapper.mapToDomain(it)
        }
    }

    override suspend fun getEnglishListLetter(letter: String): List<Word> {
        return source.readWordsLetter(letter).map {
            mapper.mapToDomain(it)
        }
    }

    override suspend fun addNewEnglishWord(word: Word) {
        source.insertToWords(mapper.mapToEntity(word))
    }

    override suspend fun checkCountsWords(): Int {
        return source.checkWordsTable()
    }

    override fun checkListIsEmpty(): Boolean {
        return source.checkIsEmpty()
    }
}