package com.donggukthon.team5.presentation.fireplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FireplaceRecordViewModel: ViewModel() {

    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)

    val recordContent: MutableLiveData<String> = MutableLiveData()

    private val _recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val recordEnabled: LiveData<Boolean>
        get() = _recordEnabled

    fun isRecordCheckEnabled() {
        _recordEnabled.value = !recordContent.value.isNullOrEmpty()
    }
}