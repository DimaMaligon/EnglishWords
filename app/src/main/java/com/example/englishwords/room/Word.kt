package com.example.englishwords.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(
    var letter: String,
    var wordEnglish: String,
    var translate: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
