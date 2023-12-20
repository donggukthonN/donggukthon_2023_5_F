package com.donggukthon.team5.presentation.tree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.domain.model.TreeOverview
import com.donggukthon.team5.domain.repository.MemoRepository
import com.donggukthon.team5.domain.repository.TreeRepository
import com.donggukthon.team5.presentation.home.HomeViewModel.Companion.TREE_ID
import com.donggukthon.team5.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreeRecordViewModel @Inject constructor(
    private val treeRepository: TreeRepository,
    private val memoRepository: MemoRepository
) : ViewModel() {
    val btnVisible: MutableLiveData<Boolean> = MutableLiveData(true)
    val recordContent: MutableLiveData<String> = MutableLiveData()
    private val _recordEnabled: MutableLiveData<Boolean> = MutableLiveData()
    val recordEnabled: LiveData<Boolean>
        get() = _recordEnabled
    private val _treeOverviewState = MutableStateFlow<UiState<TreeOverview>>(UiState.Empty)
    val treeOverviewState = _treeOverviewState.asStateFlow()
    private val _memoState = MutableStateFlow<UiState<Int>>(UiState.Empty)
    val memoState = _memoState.asStateFlow()

    init {
        getTreeOverview()
    }

    fun isRecordCheckEnabled() {
        _recordEnabled.value = !recordContent.value.isNullOrEmpty()
    }

    private fun getTreeOverview() {
        viewModelScope.launch {
            _treeOverviewState.value = UiState.Loading
            treeRepository.getTreeOverView(TREE_ID)
                .onSuccess { treeOverview ->
                    _treeOverviewState.value = UiState.Success(treeOverview)
                }
                .onFailure { exception: Throwable ->
                    _treeOverviewState.value = UiState.Error(exception.message)
                }
        }
    }

    fun postMemo() {
        viewModelScope.launch {
            _memoState.value = UiState.Loading
            recordContent.value?.let {
                memoRepository.postMemo(
                    treeId = TREE_ID,
                    memoType = GOOD,
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
        const val GOOD = "GOOD"
    }
}