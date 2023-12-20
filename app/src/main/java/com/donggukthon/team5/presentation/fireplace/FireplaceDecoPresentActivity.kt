package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceDecoPresentBinding
import com.donggukthon.team5.presentation.treedetail.TreeDetailActivity
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceDecoPresentActivity :
    BindingActivity<ActivityFireplaceDecoPresentBinding>(R.layout.activity_fireplace_deco_present) {

    private val viewModel by viewModels<FirePlaceDecoPresentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

        viewModel.getTreeId()
        initSetWhatPresent()
        addListeners()
    }

    private fun initSetWhatPresent() {
        val drawableResId = when (viewModel.treeId.value) {
            1 -> R.drawable.ic_home_hat
            3 -> R.drawable.ic_home_light_bulb
            5 -> R.drawable.ic_home_cookie
            8 -> R.drawable.ic_home_socks
            11 -> R.drawable.ic_home_candy
            else -> R.drawable.ic_home_hat
        }

        binding.ivFireplaceWhatPresentImg.setImageResource(drawableResId)
    }

    private fun addListeners() {
        binding.btnFirePlaceButton.setOnClickListener {
            Intent(this@FireplaceDecoPresentActivity, TreeDetailActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}