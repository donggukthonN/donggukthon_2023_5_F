package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceGetPresentBinding
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceGetPresentActivity: BindingActivity<ActivityFireplaceGetPresentBinding>(R.layout.activity_fireplace_get_present) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initSetPresentVisible()
    }

    private fun initSetPresentVisible() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.presentVisible.value = false
        }, 1500L)

    }
}