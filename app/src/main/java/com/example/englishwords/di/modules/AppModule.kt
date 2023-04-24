package com.example.englishwords.di.modules

import android.app.Application
import com.example.englishwords.db.MyDbManager
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
    fun provideMyDbManager(application: Application): MyDbManager {
        return MyDbManager(application)
    }
}