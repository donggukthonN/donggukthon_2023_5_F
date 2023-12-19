package com.donggukthon.team5.presentation.tree.record

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentTreeRecordDialogBinding
import com.donggukthon.team5.databinding.FragmentTreeRecordDialogHintBinding
import com.donggukthon.team5.presentation.tree.TreeActivity
import com.donggukthon.team5.presentation.tree.TreeViewModel
import com.donggukthon.team5.util.binding.BindingDialogFragment
import timber.log.Timber

class TreeRecordDialogFragment: BindingDialogFragment<FragmentTreeRecordDialogBinding>(R.layout.fragment_tree_record_dialog) {

    private val viewModel by viewModels<TreeViewModel>()
    //lateinit var viewModel : TreeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dialog?.window?.setGravity(Gravity.BOTTOM)
//        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        //viewModel = ViewModelProvider(requireActivity()).get(TreeViewModel::class.java)
        binding.viewModel = viewModel

        initMakeRecordContent()

    }

    private fun initMakeRecordContent() {
        viewModel.recordContent.observe(requireActivity()) {
            Log.d("TreeViewModel:fragme: ", viewModel.recordContent.value.toString())
            //Log.d("TreeViewModel:fragme:", viewModel.recordEnabled.value.toString())
            Log.d("TreeViewModel:", viewModel.isRecordCheckEnabled().toString())
        }

    }
}