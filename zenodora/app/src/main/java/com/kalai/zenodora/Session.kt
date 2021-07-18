package com.kalai.zenodora

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Session(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "type") val type: SessionType,
    @ColumnInfo(name = "time_span") val timeSpan: Int,
    @ColumnInfo(name ="start_time") val startTime: Date
)