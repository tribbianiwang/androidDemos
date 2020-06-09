package com.wl.androiddemos.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    init {
        viewModelScope.launch {
         Log.d("myviewmodel","gettingCoroutineScope")
        }

    }

    val result = liveData(Dispatchers.IO){
        emit(getResult())
    }

    fun getResult():String{
        return "this is a test getResult"
    }


}