package com.donggukthon.team5.presentation.addtree

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityAddTreeBinding
import com.donggukthon.team5.presentation.tree.TreeRecordActivity.Companion.ORNAMENT_ID
import com.donggukthon.team5.presentation.treedetail.TreeDetailActivity
import com.donggukthon.team5.util.binding.BindingActivity

class AddTreeActivity : BindingActivity<ActivityAddTreeBinding>(R.layout.activity_add_tree) {
    private val addTreeViewModel by viewModels<AddTreeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = addTreeViewModel

        setOrnamentId()
        addListeners()
        initView()
    }

    private fun setOrnamentId() {
        addTreeViewModel.setOrnamentId(intent.getIntExtra(ORNAMENT_ID, 0))
    }

    private fun addListeners() {
        binding.ivAddTreeAdd.setOnClickListener {
            moveToTreeDetail()
        }
    }

    private fun moveToTreeDetail() {
        Intent(this@AddTreeActivity, TreeDetailActivity::class.java).apply {
            // TODO 트리 값 다시 한 번 받아오기
            startActivity(this)
        }
    }

    private fun initView() {
        val drawableResId = when (addTreeViewModel.ornamentId.value) {
            2 -> R.drawable.ic_tree_detail_ball2
            4 -> R.drawable.ic_tree_detail_ball3
            6 -> R.drawable.ic_tree_detail_ball4
            7 -> R.drawable.ic_tree_detail_ball5
            9 -> R.drawable.ic_tree_detail_ball6
            10 -> R.drawable.ic_tree_detail_ball7
            12 -> R.drawable.ic_tree_detail_ball8
            13 -> R.drawable.ic_tree_detail_ball9
            else -> R.drawable.ic_tree_detail_ball1
        }

        binding.ivAddTreeAdd.setImageResource(drawableResId)
    }
}