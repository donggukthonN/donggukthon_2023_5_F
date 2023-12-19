package com.donggukthon.team5.presentation.fireplace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFirePlaceBinding
import com.donggukthon.team5.util.binding.BindingActivity

class FirePlaceActivity : BindingActivity<ActivityFirePlaceBinding>(R.layout.activity_fire_place) {
    private val firePlaceViewModel by viewModels<FirePlaceViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = firePlaceViewModel

        addListeners()
    }

    private fun addListeners() {
        binding.ivFirePlaceHome.setOnClickListener {
            finish()
        }
    }
}