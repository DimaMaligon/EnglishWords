package com.englishwords.data

import com.englishwords.data.model.WordDbModel
import com.englishwords.domain.models.Word

interface Mapper {
    fun mapToDomain(type: WordDbModel): Word

    fun mapToEntity(type: Word): WordDbModel
}