package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceRecordBinding
import com.donggukthon.team5.presentation.fireplace.record.FireplaceRecordDialogHintFragment
import com.donggukthon.team5.presentation.tree.TreeRecordActivity.Companion.ORNAMENT_ID
import com.donggukthon.team5.util.UiState
import com.donggukthon.team5.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FireplaceRecordActivity :
    BindingActivity<ActivityFireplaceRecordBinding>(R.layout.activity_fireplace_record) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()
    private var recordDialog: FireplaceRecordDialogHintFragment =
        FireplaceRecordDialogHintFragment(clickRecordBtn = ::postMemo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initSetRecordDialog()
        collectData()
    }

    private fun initSetRecordDialog() {
        binding.btnFireplaceRecord.setOnClickListener {
            recordDialog.show(supportFragmentManager, DIALOG_TAG)
            viewModel.btnVisible.value = false
        }
    }

    private fun collectData() {
        viewModel.memoState.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    moveToFirePlaceBurnActivity(uiState.data)
                }

                else -> Unit
            }
        }
    }

    private fun moveToFirePlaceBurnActivity(ornamentId: Int) {
        Intent(this@FireplaceRecordActivity, FireplaceBurnActivity::class.java).apply {
            putExtra(ORNAMENT_ID, ornamentId)
            startActivity(this)
        }
    }

    private fun postMemo() {
        viewModel.postMemo()
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}