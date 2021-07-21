package com.kalai.zenodora

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) :ViewModel() {

    val allSession: LiveData<List<Session>> = repository.allSessions.asLiveData()

    fun insert(){
        viewModelScope.launch {
            repository.insert(Session("Study Physics I","Description",SessionType.STUDY,20, Date())
            ,Session("Study Physics54","Description",SessionType.STUDY,20, Date()),
                Session("Study2345cs I","Description",SessionType.STUDY,20, Date()),Session("Study Physics I","Description",SessionType.STUDY,20, Date())
            ,Session("Study Ph2345 I","Description",SessionType.STUDY,20, Date()))
        }
    }


}




