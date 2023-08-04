package com.example.englishwords.di.modules

import android.app.Application
import com.example.englishwords.data.sources.room.db.DbManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDbManager(application: Application): DbManager {
        return DbManager(application)
    }
}