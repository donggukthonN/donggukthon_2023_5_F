package com.donggukthon.team5.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityHomeBinding
import com.donggukthon.team5.presentation.fireplace.FireplaceRecordActivity
import com.donggukthon.team5.presentation.tree.TreeRecordActivity
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import com.donggukthon.team5.util.extension.setInvisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = homeViewModel

        addListeners()
        collectData()
    }

    private fun addListeners() {
        binding.btnHomeTree.setOnClickListener {
            moveToTree()
        }

        binding.ivHomeTree.setOnClickListener {
            moveToTree()
        }

        binding.btnHomeStove.setOnClickListener {
            moveToFirePlace()
        }

        binding.ivHomeFirePlace.setOnClickListener {
            moveToFirePlace()
        }
    }

    private fun collectData() {
        homeViewModel.treeOverviewState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    with(binding) {
                        ivHomeLightBulb.setInvisibility(uiState.data.ornamentOverviewList[3])
                        ivHomeBall1.setInvisibility(uiState.data.ornamentOverviewList[0])
                        ivHomeHat.setInvisibility(uiState.data.ornamentOverviewList[1])
                        ivHomeBall2.setInvisibility(uiState.data.ornamentOverviewList[2])
                        ivHomeBall3.setInvisibility(uiState.data.ornamentOverviewList[4])
                        ivHomeCookie.setInvisibility(uiState.data.ornamentOverviewList[5])
                        ivHomeBall5.setInvisibility(uiState.data.ornamentOverviewList[6])
                        ivHomeBall4.setInvisibility(uiState.data.ornamentOverviewList[7])
                        ivHomeSocks.setInvisibility(uiState.data.ornamentOverviewList[8])
                        ivHomeBall6.setInvisibility(uiState.data.ornamentOverviewList[9])
                        ivHomeBall7.setInvisibility(uiState.data.ornamentOverviewList[10])
                        ivHomeCandy.setInvisibility(uiState.data.ornamentOverviewList[11])
                        ivHomeBall8.setInvisibility(uiState.data.ornamentOverviewList[12])
                        ivHomeBall9.setInvisibility(uiState.data.ornamentOverviewList[13])
                    }
                }

                else -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToTree() {
        Intent(this@HomeActivity, TreeRecordActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun moveToFirePlace() {
        Intent(this@HomeActivity, FireplaceRecordActivity::class.java).apply {
            startActivity(this)
        }
    }
}