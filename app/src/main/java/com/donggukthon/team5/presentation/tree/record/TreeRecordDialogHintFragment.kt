package com.donggukthon.team5.presentation.tree.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentTreeRecordDialogHintBinding
import com.donggukthon.team5.presentation.tree.TreeRecordViewModel
import com.donggukthon.team5.util.binding.BindingDialogFragment

class TreeRecordDialogHintFragment(
    private val clickRecordBtn: () -> Unit = {},
    private val onDialogClosed: () -> Unit
) :
    BindingDialogFragment<FragmentTreeRecordDialogHintBinding>(R.layout.fragment_tree_record_dialog_hint) {

    private val viewModel by viewModels<TreeRecordViewModel>()
    private var recordDialog: TreeRecordDialogFragment =
        TreeRecordDialogFragment(clickRecordBtn, onDialogClosed)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeRecordDialog()
    }

    private fun initMakeRecordDialog() {
        binding.btnTreeRecord.setOnClickListener {
            dismiss()
            clickRecordBtn.invoke()
            recordDialog.show(requireActivity().supportFragmentManager, DIALOG_TAG)
        }
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}