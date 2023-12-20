package com.donggukthon.team5.presentation.fireplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.donggukthon.team5.domain.model.RecordData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FirePlaceDecoPresentViewModel: ViewModel() {

    private val _mockData: MutableLiveData<RecordData> =
        MutableLiveData(
            RecordData(
                1,
                "Good",
                "memo"
            )
        )

    val mockData: LiveData<RecordData>
        get() = _mockData

    private val _treeId = MutableStateFlow<Int>(0)
    val treeId: StateFlow<Int>
        get() = _treeId

    fun getTreeId() {
        _treeId.value = _mockData.value?.treeId ?: 0
    }

}