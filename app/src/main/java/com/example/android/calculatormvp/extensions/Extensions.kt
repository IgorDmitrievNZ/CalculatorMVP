package com.example.android.calculatormvp.extensions

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    text: String,
    actionText: String,
    length: Int = Snackbar.LENGTH_INDEFINITE,
    action: (View) -> Unit,
) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun Any.showToast(context: Context, text: String ): Toast {
    return Toast.makeText(context, text, Toast.LENGTH_SHORT).apply { show() }
}