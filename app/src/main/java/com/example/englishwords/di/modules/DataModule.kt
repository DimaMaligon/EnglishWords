package com.example.englishwords.di.modules

import android.app.Application
import com.example.englishwords.data.Mapper
import com.example.englishwords.data.repositories.EnglishWordRepositoryImpl
import com.example.englishwords.data.sources.room.dao.WordDaoRoom
import com.example.englishwords.data.sources.room.db.DbManager
import com.example.englishwords.data.sources.room.mapper.RoomMapper
import com.example.englishwords.domain.repository.EnglishWordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(application: Application): DbManager {
        return DbManager(application)
    }

    @Provides
    @Singleton
    fun provideWordRoomDao(wordDatabase: DbManager): WordDaoRoom {
        return wordDatabase.getDao()
    }

    @Provides
    @Singleton
    fun provideMapperRoom(): Mapper {
        return RoomMapper()
    }

    @Provides
    @Singleton
    fun provideCocktailsRepositories(wordDao: WordDaoRoom, mapper: Mapper): EnglishWordRepository =
        EnglishWordRepositoryImpl(wordDao, mapper)
}