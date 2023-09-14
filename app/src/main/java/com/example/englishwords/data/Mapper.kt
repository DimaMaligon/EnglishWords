package com.example.englishwords.data

import com.example.englishwords.data.model.WordDbModel
import com.example.englishwords.domain.models.Word

interface Mapper {
    fun mapToDomain(type: WordDbModel): Word

    fun mapToEntity(type: Word): WordDbModel
}