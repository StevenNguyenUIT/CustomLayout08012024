package com.nhinhnguyenuit.customlayout08012024

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.IntegerRes
import androidx.core.view.isGone
import androidx.core.view.isVisible

fun TextView.setTextOrGone(text: String) {
    if (text.isNotBlank()) {
        this.text = text
        this.isVisible = true
    } else {
        this.text = ""
        this.isGone = true
    }
}
