package com.donggukthon.team5.presentation.fireplace

import android.os.Bundle
import androidx.activity.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.ActivityFireplaceRecordBinding
import com.donggukthon.team5.presentation.fireplace.record.FireplaceRecordDialogHintFragment
import com.donggukthon.team5.util.binding.BindingActivity

class FireplaceRecordActivity: BindingActivity<ActivityFireplaceRecordBinding>(R.layout.activity_fireplace_record) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()
    private var recordDialog: FireplaceRecordDialogHintFragment = FireplaceRecordDialogHintFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        initSetRecordDialog()
        initSetPaperBurn()
    }

    private fun initSetRecordDialog() {
        binding.btnFireplaceRecord.setOnClickListener {
            recordDialog.show(supportFragmentManager, DIALOG_TAG)
            viewModel.btnVisible.value = false
        }
    }

    private fun initSetPaperBurn() {
        //
    }


    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}