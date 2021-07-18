package com.kalai.zenodora

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import javax.inject.Inject


class HomeViewModel@Inject constructor(
    private val repository: AppRepository
) :ViewModel() {

    val allSession: LiveData<List<Session>> = repository.allSessions.asLiveData()


}




