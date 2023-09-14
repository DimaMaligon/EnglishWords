package com.example.englishwords.data.sources.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.englishwords.data.DaoSource
import com.example.englishwords.data.model.WordDbModel

@Dao
interface WordDaoRoom : DaoSource<WordDbModel> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertToWords(word: WordDbModel)

    @Query("SELECT COUNT(*) FROM worddbmodel")
    override suspend fun checkWordsTable(): Int

    @Query("SELECT (SELECT COUNT(*) FROM worddbmodel) == 0")
    override fun checkIsEmpty(): Boolean

    @Query("SELECT * FROM worddbmodel WHERE letter = :letterScreen")
    override suspend fun readWordsLetter(letterScreen: String): MutableList<WordDbModel>

    @Query("SELECT * FROM worddbmodel ORDER BY RANDOM() LIMIT 4")
    override suspend fun readRandomWords(): MutableList<WordDbModel>

    @Query("SELECT * FROM worddbmodel WHERE wordEnglish LIKE '%' || :wordSearch || '%'")
    override suspend fun searchWord(wordSearch: String): WordDbModel
}