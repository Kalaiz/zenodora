package com.kalai.zenodora

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ZenodoraApplication : Application() {

    private val database by lazy { SessionDatabase.getDatabase(this) }
    val repository by lazy { AppRepository(database.sessionDao()) }
}