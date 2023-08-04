package com.example.englishwords.data.sources.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.englishwords.data.sources.model.WordDbModel

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToWords(word: WordDbModel)

    @Query("SELECT COUNT(*) FROM worddbmodel")
    suspend fun checkWordsTable(): Int

    @Query("SELECT (SELECT COUNT(*) FROM worddbmodel) == 0")
    fun checkIsEmpty(): Boolean

    @Query("SELECT * FROM worddbmodel WHERE letter = :letterScreen")
    suspend fun readWordsLetter(letterScreen: String): MutableList<WordDbModel>

    @Query("SELECT * FROM worddbmodel ORDER BY RANDOM() LIMIT 4")
    suspend fun readRandomWords(): MutableList<WordDbModel>

    @Query("SELECT * FROM worddbmodel WHERE wordEnglish LIKE '%' || :wordSearch || '%'")
    suspend fun searchWord(wordSearch: String): WordDbModel
}