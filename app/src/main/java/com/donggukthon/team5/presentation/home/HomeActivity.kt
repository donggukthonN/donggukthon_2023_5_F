package com.donggukthon.team5.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityHomeBinding
import com.donggukthon.team5.presentation.fireplace.FirePlaceActivity
import com.donggukthon.team5.presentation.tree.TreeActivity
import com.donggukthon.team5.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = homeViewModel

        addListeners()
    }

    private fun addListeners() {
        binding.btnHomeTree.setOnClickListener {
            moveToTree()
        }

        binding.ivHomeTree.setOnClickListener {
            moveToTree()
        }

        binding.btnHomeStove.setOnClickListener {
            moveToFirePlace()
        }

        binding.ivHomeFirePlace.setOnClickListener {
            moveToFirePlace()
        }
    }

    private fun moveToTree() {
        Intent(this@HomeActivity, TreeActivity::class.java).apply {
            startActivity(this)
        }
    }

    private fun moveToFirePlace() {
        Intent(this@HomeActivity, FirePlaceActivity::class.java).apply {
            startActivity(this)
        }
    }
}