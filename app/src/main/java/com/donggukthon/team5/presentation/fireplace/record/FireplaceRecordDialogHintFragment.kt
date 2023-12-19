package com.donggukthon.team5.presentation.fireplace.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentFireplaceRecordDialogHintBinding
import com.donggukthon.team5.presentation.fireplace.FireplaceRecordViewModel
import com.donggukthon.team5.presentation.tree.TreeRecordViewModel
import com.donggukthon.team5.presentation.tree.record.TreeRecordDialogFragment
import com.donggukthon.team5.util.binding.BindingDialogFragment

class FireplaceRecordDialogHintFragment: BindingDialogFragment<FragmentFireplaceRecordDialogHintBinding>(R.layout.fragment_fireplace_record_dialog_hint) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()
    private var recordDialog: FireplaceRecordDialogFragment = FireplaceRecordDialogFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeRecordDialog()
    }

    private fun initMakeRecordDialog() {
        binding.btnFireplaceRecord.setOnClickListener {
            dismiss()
            recordDialog.show(requireActivity().supportFragmentManager, DIALOG_TAG)
        }
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}