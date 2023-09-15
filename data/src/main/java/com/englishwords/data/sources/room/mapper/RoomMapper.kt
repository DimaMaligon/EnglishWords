package com.englishwords.data.sources.room.mapper

import com.englishwords.data.Mapper
import com.englishwords.data.model.WordDbModel
import com.englishwords.domain.models.Word

class RoomMapper: Mapper {
    override fun mapToDomain(type: WordDbModel): Word {
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