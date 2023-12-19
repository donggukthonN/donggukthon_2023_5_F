package com.donggukthon.team5.presentation.tree

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeRecordBinding
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogHintFragment
import com.donggukthon.team5.util.binding.BindingActivity

class TreeRecordActivity : BindingActivity<ActivityTreeRecordBinding>(R.layout.activity_tree_record) {

    private val viewModel by viewModels<TreeViewModel>()
    private var recordDialog: TreeRecordDialogHintFragment = TreeRecordDialogHintFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel

        initSetRecordDialog()
    }

    private fun initSetRecordDialog() {
        binding.btnTreeMakeDecor.setOnClickListener {
            recordDialog.show(supportFragmentManager, DIALOG_TAG)
            viewModel.btnVisible.value = false
        }
    }


    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}