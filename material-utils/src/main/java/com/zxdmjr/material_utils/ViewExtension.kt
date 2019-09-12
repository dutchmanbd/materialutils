package com.zxdmjr.material_utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, length).show()
}

