package com.example.englishwords.data.sources.room.storage

import android.app.Application
import com.example.englishwords.data.sources.WordStorage
import com.example.englishwords.data.sources.model.WordDbModel
import com.example.englishwords.data.sources.room.db.DbManager

class RoomStorage(private val application: Application): WordStorage{
    private val dbManager = DbManager(application)
    private val daoData = dbManager.getDao()

    override suspend fun getRandomEnglishWords(): MutableList<WordDbModel> {
        return daoData.readRandomWords()
    }

    override suspend fun getEnglishTranslateWord(word: String): WordDbModel {
        return daoData.searchWord(word)
    }

    override suspend fun getEnglishListLetter(letter: String): MutableList<WordDbModel> {
        return daoData.readWordsLetter(letter)
    }

    override suspend fun addNewEnglishWord(word: WordDbModel) {
        daoData.insertToWords(word)
    }

    override suspend fun checkCountsWords(): Int {
        return daoData.checkWordsTable()
    }

    override fun checkListIsEmpty(): Boolean {
        return daoData.checkIsEmpty()
    }
}