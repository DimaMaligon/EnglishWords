package com.englishwords.data.di.modules

import com.englishwords.domain.repository.EnglishWordRepository
import com.englishwords.domain.usecases.LetterWordsUseCases
import com.englishwords.domain.usecases.RepeatWordsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCasesModule {

    @Provides
    fun providesLetterWords(englishRoomRepository: EnglishWordRepository): LetterWordsUseCases {
        return LetterWordsUseCases(englishRoomRepository)
    }

    @Provides
    fun providesRepeatWords(englishRoomRepository: EnglishWordRepository): RepeatWordsUseCases {
        return RepeatWordsUseCases(englishRoomRepository)
    }

}