package com.donggukthon.team5.presentation.fireplace

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.domain.repository.MemoRepository
import com.donggukthon.team5.presentation.home.HomeViewModel
import com.donggukthon.team5.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FireplaceRecordViewModel @Inject constructor(
    private val memoRepository: MemoRepository
) : ViewModel() {
    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)
    val recordContent: MutableLiveData<String> = MutableLiveData()
    private val _recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val recordEnabled: LiveData<Boolean>
        get() = _recordEnabled
    val paperVisible: MutableLiveData<Boolean> = MutableLiveData(true)
    val presentVisible: MutableLiveData<Boolean> = MutableLiveData(true)
    private val _memoState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val memoState = _memoState.asStateFlow()

    fun isRecordCheckEnabled() {
        _recordEnabled.value = !recordContent.value.isNullOrEmpty()
    }

    fun postMemo() {
        viewModelScope.launch {
            _memoState.value = UiState.Loading
            recordContent.value?.let {
                memoRepository.postMemo(
                    treeId = HomeViewModel.TREE_ID,
                    memoType = BAD,
                    memo = it
                )
                    .onSuccess { ornamentId ->
                        _memoState.value = UiState.Success(ornamentId)
                    }
                    .onFailure { exception: Throwable ->
                        _memoState.value = UiState.Error(exception.message)
                    }
            }
        }
    }

    companion object {
        const val BAD = "BAD"
    }
}