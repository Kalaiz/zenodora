package com.kalai.zenodora.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM session")
    fun getAll(): Flow<List<Session>>

    @Insert
    suspend fun insert(vararg session: Session)

    @Delete
    suspend fun delete(vararg session: Session)

    @Update
    suspend fun update(vararg session: Session)
}