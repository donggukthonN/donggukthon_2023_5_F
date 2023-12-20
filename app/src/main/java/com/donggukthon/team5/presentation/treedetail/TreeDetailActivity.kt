package com.donggukthon.team5.presentation.treedetail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeDetailBinding
import com.donggukthon.team5.presentation.tree.TreeRecordActivity
import com.donggukthon.team5.util.binding.BindingActivity

class TreeDetailActivity :
    BindingActivity<ActivityTreeDetailBinding>(R.layout.activity_tree_detail) {
    private val treeDetailViewModel by viewModels<TreeDetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = treeDetailViewModel

        addListeners()
    }

    private fun addListeners() {
        binding.ivTreeDetailReturn.setOnClickListener {
            moveToTree()
        }
    }

    private fun moveToTree() {
        Intent(this@TreeDetailActivity, TreeRecordActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}