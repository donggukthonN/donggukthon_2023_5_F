package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceAfterBurnBinding
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceAfterBurnActivity: BindingActivity<ActivityFireplaceAfterBurnBinding>(R.layout.activity_fireplace_after_burn) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initGoNextPage()
    }

//    private fun initGoNextPage() {
//        val intent = Intent(this, )
//        Handler(Looper.getMainLooper()).postDelayed({
//            viewModel.paperVisible.value = false
//        }, 1000L)
//    }
}