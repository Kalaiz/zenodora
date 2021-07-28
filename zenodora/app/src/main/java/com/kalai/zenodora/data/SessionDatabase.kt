package com.kalai.zenodora.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kalai.zenodora.Converters

@Database(entities = [Session::class], version = 1)
@TypeConverters(Converters::class)
abstract class SessionDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao
}