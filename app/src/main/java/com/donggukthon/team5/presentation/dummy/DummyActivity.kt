package com.donggukthon.team5.presentation.dummy

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityDummyBinding
import com.donggukthon.team5.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DummyActivity : BindingActivity<ActivityDummyBinding>(R.layout.activity_dummy) {
    private val viewModel: DummyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    private fun initLayout() {
        TODO("Not yet implemented")
    }

    private fun addListeners() {
        TODO("Not yet implemented")
    }

    private fun addObservers() {
        TODO("Not yet implemented")
    }
}