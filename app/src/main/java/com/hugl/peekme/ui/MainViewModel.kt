package com.hugl.peekme.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hugl.peekme.domain.Heroes
import com.hugl.peekme.domain.Models
import com.hugl.peekme.remote.Resource
import com.hugl.peekme.ui.base.BaseViewModel
import com.task.data.DataRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainViewModel  @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel(){

    val  heroesLiveData: LiveData<Resource<Heroes>> get() = heroesLiveDataPrivate
    private val heroesLiveDataPrivate = MutableLiveData<Resource<Heroes>>()


    fun initIntentData() {
        viewModelScope.launch {
            heroesLiveDataPrivate.value = Resource.Loading()
            dataRepository.requestHeroes().collect {
                heroesLiveDataPrivate.value = it
            }
        }
    }

}

