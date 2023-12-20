package com.donggukthon.team5.presentation.addtree

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityAddTreeBinding
import com.donggukthon.team5.presentation.tree.TreeRecordActivity.Companion.ORNAMENT_ID
import com.donggukthon.team5.presentation.treedetail.TreeDetailActivity
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import com.donggukthon.team5.util.extension.setInvisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddTreeActivity : BindingActivity<ActivityAddTreeBinding>(R.layout.activity_add_tree) {
    private val addTreeViewModel by viewModels<AddTreeViewModel>()
    private lateinit var ornamentView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = addTreeViewModel

        setOrnamentId()
        addListeners()
        initView()
        collectData()
    }

    private fun setOrnamentId() {
        addTreeViewModel.setOrnamentId(intent.getIntExtra(ORNAMENT_ID, 0))
    }

    private fun addListeners() {
        binding.ivAddTreeAdd.setOnClickListener {
            moveToTreeDetail()
        }
    }

    private fun collectData() {
        addTreeViewModel.treeOverviewState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    with(binding) {
                        ivAddTreeLightBulb.setInvisibility(uiState.data.ornamentOverviewList[3])
                        ivAddTreeBall1.setInvisibility(uiState.data.ornamentOverviewList[0])
                        ivAddTreeHat.setInvisibility(uiState.data.ornamentOverviewList[1])
                        ivAddTreeBall2.setInvisibility(uiState.data.ornamentOverviewList[2])
                        ivAddTreeBall3.setInvisibility(uiState.data.ornamentOverviewList[4])
                        ivAddTreeCookie.setInvisibility(uiState.data.ornamentOverviewList[5])
                        ivAddTreeBall5.setInvisibility(uiState.data.ornamentOverviewList[6])
                        ivAddTreeBall4.setInvisibility(uiState.data.ornamentOverviewList[7])
                        ivAddTreeSocks.setInvisibility(uiState.data.ornamentOverviewList[8])
                        ivAddTreeBall6.setInvisibility(uiState.data.ornamentOverviewList[9])
                        ivAddTreeBall7.setInvisibility(uiState.data.ornamentOverviewList[10])
                        ivAddTreeCandy.setInvisibility(uiState.data.ornamentOverviewList[11])
                        ivAddTreeBall8.setInvisibility(uiState.data.ornamentOverviewList[12])
                        ivAddTreeBall9.setInvisibility(uiState.data.ornamentOverviewList[13])
                    }

                    Log.e("ㅋㅋ", "돌아가나요???")

                    ornamentView.setInvisibility(false)
                }

                else -> Log.e("ㅋㅋ", uiState.toString())
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToTreeDetail() {
        addTreeViewModel.viewModelScope.launch {
            Intent(this@AddTreeActivity, TreeDetailActivity::class.java).apply {
                ornamentView.setInvisibility(true)
                delay(1500)
                startActivity(this)
            }
        }
    }

    private fun initView() {
        val drawableResId = when (addTreeViewModel.ornamentId.value) {
            1 -> R.drawable.ic_tree_detail_hat
            2 -> R.drawable.ic_tree_detail_ball2
            3 -> R.drawable.ic_tree_detail_light_bulb
            4 -> R.drawable.ic_tree_detail_ball3
            5 -> R.drawable.ic_tree_detail_cookie
            6 -> R.drawable.ic_tree_detail_ball4
            7 -> R.drawable.ic_tree_detail_ball5
            8 -> R.drawable.ic_tree_detail_socks
            9 -> R.drawable.ic_tree_detail_ball6
            10 -> R.drawable.ic_tree_detail_ball7
            11 -> R.drawable.ic_tree_detail_candy
            12 -> R.drawable.ic_tree_detail_ball8
            13 -> R.drawable.ic_tree_detail_ball9
            else -> R.drawable.ic_tree_detail_ball1
        }

        binding.ivAddTreeAdd.setImageResource(drawableResId)

        ornamentView = when (addTreeViewModel.ornamentId.value) {
            0 -> binding.ivAddTreeBall1
            1 -> binding.ivAddTreeHat
            2 -> binding.ivAddTreeBall2
            3 -> binding.ivAddTreeLightBulb
            4 -> binding.ivAddTreeBall3
            5 -> binding.ivAddTreeCookie
            6 -> binding.ivAddTreeBall4
            7 -> binding.ivAddTreeBall5
            8 -> binding.ivAddTreeSocks
            9 -> binding.ivAddTreeBall6
            10 -> binding.ivAddTreeBall7
            11 -> binding.ivAddTreeCandy
            12 -> binding.ivAddTreeBall8
            else -> binding.ivAddTreeBall9
        }
    }
}