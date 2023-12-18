package com.donggukthon.team5.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.domain.repository.DummyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyRepository: DummyRepository,
) : ViewModel() {

    fun uploadDummy() {
        viewModelScope.launch {
            dummyRepository.uploadDummy(NAME, DUMMY)
                .onSuccess {

                }
                .onFailure {

                }
        }
    }

    companion object {
        const val NAME = "name"
        const val DUMMY = "dummy"
    }
}
