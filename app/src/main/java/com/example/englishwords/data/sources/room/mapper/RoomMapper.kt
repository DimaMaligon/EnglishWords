package com.example.englishwords.data.sources.room.mapper

import com.example.englishwords.data.Mapper
import com.example.englishwords.data.model.WordDbModel
import com.example.englishwords.domain.models.Word

class RoomMapper: Mapper {
    override fun mapFromEntity(type: WordDbModel): Word {
        return with(type) {
            Word(
                letter = letter,
                wordEnglish = wordEnglish,
                translate = translate
            )
        }
    }

    override fun mapToEntity(type: Word): WordDbModel {
        return with(type) {
            WordDbModel(
                letter = letter,
                wordEnglish = wordEnglish,
                translate = translate
            )
        }
    }
}