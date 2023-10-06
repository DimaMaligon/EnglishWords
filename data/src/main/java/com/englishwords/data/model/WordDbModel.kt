package com.englishwords.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WordDbModel(
    var letter: String,
    var wordEnglish: String,
    var translate: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
