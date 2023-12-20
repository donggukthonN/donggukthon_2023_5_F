package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceBurnBinding
import com.donggukthon.team5.util.binding.BindingActivity
import kotlinx.coroutines.delay

class FireplaceBurnActivity :
    BindingActivity<ActivityFireplaceBurnBinding>(R.layout.activity_fireplace_burn) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        initSetPaperVisible()
    }

    private fun initSetPaperVisible() {

        val intent = Intent(this, FireplaceAfterBurnActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.paperVisible.value = false
            startActivity(intent)
            finish()
        }, 1500L)


    }
}