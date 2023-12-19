package com.donggukthon.team5.presentation.fireplace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FireplaceRecordViewModel: ViewModel() {

    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)
}