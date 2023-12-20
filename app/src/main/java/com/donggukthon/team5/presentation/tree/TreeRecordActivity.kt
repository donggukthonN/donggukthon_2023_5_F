package com.donggukthon.team5.presentation.tree

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeRecordBinding
import com.donggukthon.team5.presentation.addtree.AddTreeActivity
import com.donggukthon.team5.presentation.home.HomeActivity
import com.donggukthon.team5.presentation.tree.pastrecord.TreePastRecordActivity
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogHintFragment
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import com.donggukthon.team5.util.extension.setInvisibility
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TreeRecordActivity :
    BindingActivity<ActivityTreeRecordBinding>(R.layout.activity_tree_record) {

    private val treeViewModel by viewModels<TreeRecordViewModel>()
    private var recordDialog: TreeRecordDialogHintFragment =
        TreeRecordDialogHintFragment(clickRecordBtn = ::postMemo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = treeViewModel

        addListeners()
        collectData()
        initSetRecordDialog()
        initSetPastRecordDialog()
    }

    private fun addListeners() {
        binding.ivTreeHome.setOnClickListener {
            Intent(this@TreeRecordActivity, HomeActivity::class.java).apply {
                startActivity(this)
                finish()
            }
            finish()
        }
    }

    private fun collectData() {
        treeViewModel.treeOverviewState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    with(binding) {
                        ivTreeLightBulb.setInvisibility(uiState.data.ornamentOverviewList[3])
                        ivTreeBall1.setInvisibility(uiState.data.ornamentOverviewList[0])
                        ivTreeHat.setInvisibility(uiState.data.ornamentOverviewList[1])
                        ivTreeBall2.setInvisibility(uiState.data.ornamentOverviewList[2])
                        ivTreeBall3.setInvisibility(uiState.data.ornamentOverviewList[4])
                        ivTreeCookie.setInvisibility(uiState.data.ornamentOverviewList[5])
                        ivTreeBall5.setInvisibility(uiState.data.ornamentOverviewList[6])
                        ivTreeBall4.setInvisibility(uiState.data.ornamentOverviewList[7])
                        ivTreeSocks.setInvisibility(uiState.data.ornamentOverviewList[8])
                        ivTreeBall6.setInvisibility(uiState.data.ornamentOverviewList[9])
                        ivTreeBall7.setInvisibility(uiState.data.ornamentOverviewList[10])
                        ivTreeCandy.setInvisibility(uiState.data.ornamentOverviewList[11])
                        ivTreeBall8.setInvisibility(uiState.data.ornamentOverviewList[12])
                        ivTreeBall9.setInvisibility(uiState.data.ornamentOverviewList[13])
                    }
                }

                else -> Unit
            }
        }.launchIn(lifecycleScope)

        treeViewModel.memoState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    moveToAddTree(uiState.data)
                }

                else -> Unit
            }
        }.launchIn(lifecycleScope)
    }

    private fun initSetRecordDialog() {
        binding.btnTreeDecorate.setOnClickListener {
            recordDialog.show(supportFragmentManager, DIALOG_TAG)
            treeViewModel.btnVisible.value = false
        }
    }

    private fun initSetPastRecordDialog() {
        binding.btnTreePreviousRecord.setOnClickListener {
            Intent(this@TreeRecordActivity, TreePastRecordActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun moveToAddTree(ornamentId: Int) {
        Intent(this@TreeRecordActivity, AddTreeActivity::class.java).apply {
            putExtra(ORNAMENT_ID, ornamentId)
            startActivity(this)
        }
    }

    private fun postMemo() {
        treeViewModel.postMemo()
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
        const val ORNAMENT_ID = "ornamentId"
    }
}