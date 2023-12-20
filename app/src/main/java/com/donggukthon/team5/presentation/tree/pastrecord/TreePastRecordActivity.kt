package com.donggukthon.team5.presentation.tree.pastrecord

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreePastRecordBinding
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.MultiBrowseCarouselStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TreePastRecordActivity :
    BindingActivity<ActivityTreePastRecordBinding>(R.layout.activity_tree_past_record) {

    private val viewModel by viewModels<TreePastRecordViewModel>()

    private var _pastRecordAdapter: TreePastRecordAdapter? = null
    private val pastRecordAdapter
        get() = requireNotNull(_pastRecordAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initMakePastRecordCarousel()
    }

    private fun initMakePastRecordCarousel() {
        _pastRecordAdapter = TreePastRecordAdapter(this)
        binding.rcvTreePastRecord.adapter = pastRecordAdapter
        binding.rcvTreePastRecord.layoutManager =
            CarouselLayoutManager(MultiBrowseCarouselStrategy())
//        viewModel.mockPastRecordList.observe(this) {
//            pastRecordAdapter.submitList(it)
//        }
        viewModel.getOrnamentList()

        viewModel.mockOrnamentList.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    pastRecordAdapter.submitList(uiState.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)

    }
}