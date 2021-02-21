package com.hugl.peekme.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hugl.peekme.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel(){
    val recipePrivate = MutableLiveData<String>()
    val recipeData: LiveData<String> get() = recipePrivate


    fun initIntentData() {
        recipePrivate.value = "sadhaisodh"
    }
}