package com.donggukthon.team5.presentation.tree.pastrecord

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.domain.model.OrnamentList
import com.donggukthon.team5.domain.repository.OrnamentListRepository
import com.donggukthon.team5.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreePastRecordViewModel @Inject constructor(
    private val ornamentListRepository: OrnamentListRepository
) : ViewModel() {

    private val _mockOrnamentList: MutableStateFlow<UiState<List<OrnamentList.OrnamentListData>>> =
        MutableStateFlow(UiState.Loading)
    val mockOrnamentList: StateFlow<UiState<List<OrnamentList.OrnamentListData>>>
        get() = _mockOrnamentList


    fun getOrnamentList() {
        viewModelScope.launch {
            ornamentListRepository.getOrnamentList().onSuccess { response ->
                Log.d("TreePastRecordViewModel:", "연결 성공")
                _mockOrnamentList.value = UiState.Success(response.data.toList())
            }.onFailure {
                Log.d("TreePastRecordViewModel:", "연결 실패")
            }
        }
    }

}