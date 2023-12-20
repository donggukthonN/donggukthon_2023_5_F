package com.donggukthon.team5.presentation.tree

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeRecordBinding
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogHintFragment
import com.donggukthon.team5.util.binding.BindingActivity

class TreeRecordActivity : BindingActivity<ActivityTreeRecordBinding>(R.layout.activity_tree_record) {

    private val treeViewModel by viewModels<TreeRecordViewModel>()
    private var recordDialog: TreeRecordDialogHintFragment = TreeRecordDialogHintFragment(clickRecordBtn = {}, ::moveToAddTree))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = treeViewModel

        addListeners()
        initSetRecordDialog()
    }

    private fun addListeners() {
        binding.ivTreeHome.setOnClickListener {
            finish()
        }
    }

    private fun initSetRecordDialog() {
        binding.btnTreeDecorate.setOnClickListener {
            recordDialog.show(supportFragmentManager, DIALOG_TAG)
            treeViewModel.btnVisible.value = false
        }
    }

    private fun moveToAddTree() {
        Intent(this@TreeActivity, AddTreeActivity::class.java).apply {
            putExtra(ORNAMENT_ID, treeViewModel.ornamentId.value)
            startActivity(this)
        }
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
        const val ORNAMENT_ID = "ornamentId"
    }
}