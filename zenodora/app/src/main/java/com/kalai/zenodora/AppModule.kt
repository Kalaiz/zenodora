package com.kalai.zenodora

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideSessionDatabase(@ApplicationContext context:Context) =
        Room
            .databaseBuilder(context,SessionDatabase::class.java,"session_database")
            .build()


    @Singleton
    @Provides
    fun provideSessionDao(database: SessionDatabase) = database.sessionDao()


}