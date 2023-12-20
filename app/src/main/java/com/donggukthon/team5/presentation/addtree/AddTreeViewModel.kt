package com.donggukthon.team5.presentation.addtree

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddTreeViewModel : ViewModel() {
    val mockOrnamentOverviewList =
        listOf(true, true, false, true, true, false, true, true, false, false, true, true, true)
    private val _ornamentId = MutableStateFlow<Int>(0)
    val ornamentId = _ornamentId.asStateFlow()

    fun setOrnamentId(ornamentId: Int) {
        _ornamentId.value = ornamentId
    }
}
