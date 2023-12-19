package com.donggukthon.team5.presentation.tree

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeBinding
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogHintFragment
import com.donggukthon.team5.util.binding.BindingActivity

class TreeActivity : BindingActivity<ActivityTreeBinding>(R.layout.activity_tree) {
    private val treeViewModel by viewModels<TreeViewModel>()
    private var recordDialog: TreeRecordDialogHintFragment = TreeRecordDialogHintFragment()

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
            binding.btnTreeDecorate.visibility = View.INVISIBLE
            binding.tvTreePreviousRecord.visibility = View.INVISIBLE
        }
    }


    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}