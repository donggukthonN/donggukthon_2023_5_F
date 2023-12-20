package com.donggukthon.team5.presentation.tree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TreeViewModel : ViewModel() {
    val mockOrnamentOverviewList =
        listOf(true, true, false, true, true, false, true, true, false, false, true, true, true)

    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)

    val recordContent: MutableLiveData<String> = MutableLiveData()

    private val _recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val recordEnabled: LiveData<Boolean>
        get() = _recordEnabled

    fun isRecordCheckEnabled() {
        _recordEnabled.value = !recordContent.value.isNullOrEmpty()
    }

    private val _ornamentId = MutableStateFlow<Int>(2)
    val ornamentId = _ornamentId.asStateFlow()
}