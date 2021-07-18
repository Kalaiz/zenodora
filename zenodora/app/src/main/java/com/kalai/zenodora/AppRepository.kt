package com.kalai.zenodora

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class AppRepository(private val sessionDao:SessionDao) {

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