package com.donggukthon.team5.presentation.tree.record

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentTreeRecordDialogHintBinding
import com.donggukthon.team5.presentation.tree.TreeViewModel
import com.donggukthon.team5.util.binding.BindingDialogFragment

class TreeRecordDialogFragment: BindingDialogFragment<FragmentTreeRecordDialogHintBinding>(R.layout.fragment_tree_record_dialog) {

    private val viewModel by viewModels<TreeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}