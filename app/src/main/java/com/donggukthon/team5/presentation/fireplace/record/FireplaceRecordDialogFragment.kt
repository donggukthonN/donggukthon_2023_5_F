package com.donggukthon.team5.presentation.fireplace.record

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.donggukthon.team5.R
import com.donggukthon.team5.databinding.FragmentFireplaceRecordDialogBinding
import com.donggukthon.team5.presentation.fireplace.FireplaceRecordViewModel
import com.donggukthon.team5.util.binding.BindingDialogFragment

class FireplaceRecordDialogFragment: BindingDialogFragment<FragmentFireplaceRecordDialogBinding>(R.layout.fragment_fireplace_record_dialog) {

    private val viewModel by viewModels<FireplaceRecordViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        initClearFocus(view)
        initMakeRecordContent()

    }

    private fun initClearFocus(view: View) {
        var editText: EditText? = binding.edtFireplaceRecordContent
        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (editText?.hasFocus() == true) {
                    editText?.clearFocus()
                    hideKeyboard(view)
                }
            }
            return@setOnTouchListener false
        }
    }


    private fun hideKeyboard(view: View) {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    private fun initMakeRecordContent() {
        viewModel.recordContent.observe(requireActivity()) {
            Log.d("FireplaceViewModel:fragme: ", viewModel.recordContent.value.toString())
            Log.d("FireplaceViewModel:", viewModel.isRecordCheckEnabled().toString())
        }

    }
}