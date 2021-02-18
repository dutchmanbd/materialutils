package com.zxdmjr.material_utils.extensions

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt
import java.util.*


fun String.toSubString(separator: String = " "): String {
    val indexOf = this.indexOf(separator)
    return if(indexOf != -1) this.substring(0, indexOf) else this
}


fun String.highlight(
    query: String?,
    @ColorInt colorInt: Int = Color.RED
): SpannableString {
    val spannable = SpannableString(this)
    query?.let{
        val startIndex = this.toLowerCase(Locale.getDefault()).indexOf(it.toLowerCase(Locale.getDefault()))
        val endIndex = startIndex + it.length
        if (startIndex != -1) {
            spannable.setSpan(
                ForegroundColorSpan(colorInt),
                startIndex,
                endIndex,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
        }
    }
    return spannable
}