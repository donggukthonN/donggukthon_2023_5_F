package com.donggukthon.team5.presentation.fireplace

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceRecordBinding
import com.donggukthon.team5.presentation.tree.TreeViewModel
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceRecordActivity: BindingActivity<ActivityFireplaceRecordBinding>(R.layout.activity_fireplace_record) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
    }
}