package com.donggukthon.team5.presentation.tree

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityTreeBinding
import com.donggukthon.team5.util.binding.BindingActivity

class TreeActivity : BindingActivity<ActivityTreeBinding>(R.layout.activity_tree) {
    private val treeViewModel by viewModels<TreeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = treeViewModel

        addListeners()
    }

    private fun addListeners() {
        binding.ivTreeHome.setOnClickListener {
            finish()
        }
    }
}