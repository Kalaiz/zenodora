package com.kalai.zenodora

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun convertStartTimeToDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun convertDateToStartTime(date: Date?): Long? {
        return date?.time?.toLong()
    }
}