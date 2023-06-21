package com.example.englishwords.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToWords(word: Word)

    @Query("SELECT COUNT(*) FROM word")
    suspend fun checkWordsTable(): Int

    @Query("SELECT * FROM word WHERE letter = :letterScreen")
    suspend fun readWordsLetter(letterScreen: String): MutableList<Word>

    @Query("SELECT * FROM word ORDER BY RANDOM() LIMIT 4")
    suspend fun readRandomWords(): MutableList<Word>

    @Query("SELECT * FROM word WHERE wordEnglish = :wordSearch")
    suspend fun searchWord(wordSearch: String): Word
}