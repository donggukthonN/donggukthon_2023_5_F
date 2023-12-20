package com.donggukthon.team5.util.extension

import android.view.View
import com.donggukthon.team5.util.binding.setInvisibility
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, isShort: Boolean = true) {
    val duration = if (isShort) Snackbar.LENGTH_SHORT else Snackbar.LENGTH_LONG
    Snackbar.make(this, message, duration).show()
}

fun View.setInvisibility(isInvisible: Boolean?) {
    if (isInvisible == null) return
    this.visibility = if (isInvisible) View.VISIBLE else View.INVISIBLE
}
