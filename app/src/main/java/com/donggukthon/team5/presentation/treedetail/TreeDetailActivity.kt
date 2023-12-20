package com.donggukthon.team5.presentation.treedetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeDetailBinding
import com.donggukthon.team5.presentation.tree.TreeRecordActivity
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import com.donggukthon.team5.util.extension.setInvisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TreeDetailActivity :
    BindingActivity<ActivityTreeDetailBinding>(R.layout.activity_tree_detail) {
    private val treeDetailViewModel by viewModels<TreeDetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = treeDetailViewModel

        addListeners()
        collectData()
    }

    private fun addListeners() {
        binding.ivTreeDetailReturn.setOnClickListener {
            moveToTree()
        }
    }

    private fun collectData() {
        treeDetailViewModel.treeOverviewState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    with(binding) {
                        ivTreeDetailLightBulb.setInvisibility(uiState.data.ornamentOverviewList[3])
                        ivTreeDetailBall1.setInvisibility(uiState.data.ornamentOverviewList[0])
                        ivTreeDetailHat.setInvisibility(uiState.data.ornamentOverviewList[1])
                        ivTreeDetailBall2.setInvisibility(uiState.data.ornamentOverviewList[2])
                        ivTreeDetailBall3.setInvisibility(uiState.data.ornamentOverviewList[4])
                        ivTreeDetailCookie.setInvisibility(uiState.data.ornamentOverviewList[5])
                        ivTreeDetailBall5.setInvisibility(uiState.data.ornamentOverviewList[6])
                        ivTreeDetailBall4.setInvisibility(uiState.data.ornamentOverviewList[7])
                        ivTreeDetailSocks.setInvisibility(uiState.data.ornamentOverviewList[8])
                        ivTreeDetailBall6.setInvisibility(uiState.data.ornamentOverviewList[9])
                        ivTreeDetailBall7.setInvisibility(uiState.data.ornamentOverviewList[10])
                        ivTreeDetailCandy.setInvisibility(uiState.data.ornamentOverviewList[11])
                        ivTreeDetailBall8.setInvisibility(uiState.data.ornamentOverviewList[12])
                        ivTreeDetailBall9.setInvisibility(uiState.data.ornamentOverviewList[13])
                    }
                }

                else -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToTree() {
        Intent(this@TreeDetailActivity, TreeRecordActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}