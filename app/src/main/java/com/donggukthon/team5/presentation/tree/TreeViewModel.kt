package com.donggukthon.team5.presentation.tree

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TreeViewModel: ViewModel() {

    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)

    val recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
}