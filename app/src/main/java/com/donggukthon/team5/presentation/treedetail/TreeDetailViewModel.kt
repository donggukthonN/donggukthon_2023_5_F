package com.donggukthon.team5.presentation.treedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.domain.model.TreeOverview
import com.donggukthon.team5.domain.repository.TreeRepository
import com.donggukthon.team5.presentation.home.HomeViewModel
import com.donggukthon.team5.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreeDetailViewModel @Inject constructor(
    private val treeRepository: TreeRepository
) : ViewModel() {
    private val _treeOverviewState = MutableStateFlow<UiState<TreeOverview>>(UiState.Empty)
    val treeOverviewState = _treeOverviewState.asStateFlow()

    init {
        getTreeOverview()
    }

    private fun getTreeOverview() {
        viewModelScope.launch {
            _treeOverviewState.value = UiState.Loading
            treeRepository.getTreeOverView(HomeViewModel.TREE_ID)
                .onSuccess { treeOverview ->
                    _treeOverviewState.value = UiState.Success(treeOverview)
                }
                .onFailure { exception: Throwable ->
                    _treeOverviewState.value = UiState.Error(exception.message)
                }
        }
    }
}