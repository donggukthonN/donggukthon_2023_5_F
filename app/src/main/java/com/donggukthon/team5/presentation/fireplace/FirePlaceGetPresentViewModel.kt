package com.donggukthon.team5.presentation.fireplace

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirePlaceGetPresentViewModel: ViewModel() {

    val presentVisible: MutableLiveData<Boolean> = MutableLiveData(true)
}