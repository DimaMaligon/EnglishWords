package com.example.englishwords.data.sources

import com.example.englishwords.data.sources.model.WordDbModel
import com.example.englishwords.domain.models.Word

interface Mapper {
    fun mapFromEntity(type: WordDbModel): Word

    fun mapToEntity(type: Word): WordDbModel
}