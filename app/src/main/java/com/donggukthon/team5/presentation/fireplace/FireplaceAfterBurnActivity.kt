package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceAfterBurnBinding
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceAfterBurnActivity: BindingActivity<ActivityFireplaceAfterBurnBinding>(R.layout.activity_fireplace_after_burn) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        initGoNextPage()
        return super.dispatchTouchEvent(ev)
    }

    private fun initGoNextPage() {
        val intent = Intent(this, FireplaceGetPresentActivity::class.java)
        startActivity(intent)
        finish()
    }
}