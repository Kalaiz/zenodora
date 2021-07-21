package com.kalai.zenodora

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Session(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val  description: String,
    @ColumnInfo(name = "type") val type: SessionType,
    @ColumnInfo(name = "time_span") val timeSpan: Int,
    @ColumnInfo(name ="start_time") val startTime: Date
){
    constructor(title: String,description: String,type: SessionType,timeSpan: Int,startTime: Date) : this(0,  title, description, type, timeSpan, startTime)
}