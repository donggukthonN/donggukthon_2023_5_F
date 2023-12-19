package com.donggukthon.team5.util.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("invisibility")
fun View.setInvisibility(isInvisible: Boolean?) {
    if (isInvisible == null) return
    this.visibility = if (isInvisible) View.VISIBLE else View.INVISIBLE
}