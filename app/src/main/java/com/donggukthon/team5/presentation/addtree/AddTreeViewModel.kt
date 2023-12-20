package com.donggukthon.team5.presentation.addtree

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
class AddTreeViewModel @Inject constructor(
    private val treeRepository: TreeRepository,
) : ViewModel() {
    private val _treeOverviewState = MutableStateFlow<UiState<TreeOverview>>(UiState.Empty)
    val treeOverviewState = _treeOverviewState.asStateFlow()
    private val _ornamentId = MutableStateFlow<Int>(0)
    val ornamentId = _ornamentId.asStateFlow()

    init {
        getTreeOverview()
    }

    fun setOrnamentId(ornamentId: Int) {
        _ornamentId.value = ornamentId
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
