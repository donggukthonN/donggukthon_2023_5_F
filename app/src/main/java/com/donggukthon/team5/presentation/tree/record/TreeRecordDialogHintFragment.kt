package com.donggukthon.team5.presentation.tree.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentTreeRecordDialogHintBinding
import com.donggukthon.team5.presentation.tree.TreeViewModel
import com.donggukthon.team5.util.binding.BindingDialogFragment
import timber.log.Timber

class TreeRecordDialogHintFragment: BindingDialogFragment<FragmentTreeRecordDialogHintBinding>(R.layout.fragment_tree_record_dialog_hint) {

    private val viewModel by viewModels<TreeViewModel>()
    private var recordDialog: TreeRecordDialogFragment = TreeRecordDialogFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTreeRecord.setOnClickListener {
            dismiss()
            recordDialog.show(requireActivity().supportFragmentManager, DIALOG_TAG)
        }
    }

    companion object {
        const val DIALOG_TAG = "DIALOG_TAG"
    }
}