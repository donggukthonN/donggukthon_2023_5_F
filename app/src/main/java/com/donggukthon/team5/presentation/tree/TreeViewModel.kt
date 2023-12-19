package com.donggukthon.team5.presentation.tree

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TreeViewModel: ViewModel() {

    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)

    val recordContent: MutableLiveData<String> = MutableLiveData()
    //val recordEnabled: MutableLiveData<Boolean> = MutableLiveData()

//    val btnVisible: LiveData<Boolean>
//        get() = isRecordCheckEnabled()

    private val _recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val recordEnabled: LiveData<Boolean>
        get() = _recordEnabled

    //fun isRecordCheckEnabled(): Boolean = !recordContent.value.isNullOrEmpty()
    fun isRecordCheckEnabled() {
        _recordEnabled.value = !recordContent.value.isNullOrEmpty()
    }

}