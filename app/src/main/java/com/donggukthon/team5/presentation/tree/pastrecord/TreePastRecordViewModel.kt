package com.donggukthon.team5.presentation.tree.pastrecord

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.donggukthon.team5.domain.model.GoodMemory

class TreePastRecordViewModel: ViewModel() {

    private val _mockPastRecordList: MutableLiveData<List<GoodMemory>> = MutableLiveData(
        mutableListOf(
            GoodMemory("test1"),
            GoodMemory("test3"),
            GoodMemory("test2")
        )
    )

    val mockPastRecordList : LiveData<List<GoodMemory>>
        get() = _mockPastRecordList
}