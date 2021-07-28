package com.kalai.zenodora.data

import androidx.annotation.WorkerThread
import com.kalai.zenodora.data.Session
import com.kalai.zenodora.data.SessionDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class AppRepository @Inject constructor(private val sessionDao: SessionDao) {

    val allSessions: Flow<List<Session>> = sessionDao.getAll()


    @WorkerThread
    suspend fun insert(vararg session: Session) {
        sessionDao.insert(*session)
    }

    @WorkerThread
    suspend fun delete(vararg session: Session) {
        sessionDao.delete(*session)
    }

    @WorkerThread
    suspend fun update(vararg session: Session) {
        sessionDao.update(*session)
    }
}