package com.donggukthon.team5.presentation.tree

import android.os.Bundle
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeBinding
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogFragment
import com.donggukthon.team5.util.binding.BindingActivity

class TreeActivity: BindingActivity<ActivityTreeBinding>(R.layout.activity_tree) {

    private var recordDialog: TreeRecordDialogFragment = TreeRecordDialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSetRecordDialog()
    }

    private fun initSetRecordDialog() {
        binding.btnTreeMakeDecor.setOnClickListener {
            recordDialog.show(supportFragmentManager, "DIALOG")
        }
    }
}