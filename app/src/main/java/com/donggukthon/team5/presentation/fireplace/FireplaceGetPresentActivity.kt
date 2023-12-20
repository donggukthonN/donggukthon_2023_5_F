package com.donggukthon.team5.presentation.fireplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceGetPresentBinding
import com.donggukthon.team5.util.binding.BindingActivity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FireplaceGetPresentActivity: BindingActivity<ActivityFireplaceGetPresentBinding>(R.layout.activity_fireplace_get_present) {

    private val viewModel by viewModels<FirePlaceGetPresentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel

            //initSetPresentVisible()

    }

    private fun initSetPresentVisible() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.presentVisible.value = false
            startActivity(intent)
            finish()
        }, 1500L)

    }

//    private fun initSetChangeGetPresentView() {
//        val intent = Intent(this, FireplaceDecoPresentActivity::class.java)
//        startActivity(intent)
//        finish()
//    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        initSetChangeGetPresentView()
        return super.dispatchTouchEvent(ev)
    }

        private fun initSetChangeGetPresentView() {
    val intent = Intent(this, FireplaceDecoPresentActivity::class.java)
        viewModel.viewModelScope.launch {
            delay(1000L)
            viewModel.presentVisible.value = false
            startActivity(intent)
            finish()
        }
    }
}