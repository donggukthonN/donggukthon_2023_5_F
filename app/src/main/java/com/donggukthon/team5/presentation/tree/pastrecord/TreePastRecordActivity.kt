package com.donggukthon.team5.presentation.tree.pastrecord

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreePastRecordBinding
import com.donggukthon.team5.util.binding.BindingActivity
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.FullScreenCarouselStrategy

class TreePastRecordActivity: BindingActivity<ActivityTreePastRecordBinding>(R.layout.activity_tree_past_record) {

    private val viewModel by viewModels<TreePastRecordViewModel>()

    private var _pastRecordAdapter: TreePastRecordAdapter? = null
    private val pastRecordAdapter
        get() = requireNotNull(_pastRecordAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel


        _pastRecordAdapter = TreePastRecordAdapter(this)
        binding.rcvTreePastRecord.adapter = pastRecordAdapter
        binding.rcvTreePastRecord.layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())
        viewModel.mockPastRecordList.observe(this) {
            pastRecordAdapter.submitList(it)
        }

//        binding.run {
//            recyclerView.run{
//                adapter = TreePastRecordAdapter()
//                layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy())
//            }
//        }
    }
}