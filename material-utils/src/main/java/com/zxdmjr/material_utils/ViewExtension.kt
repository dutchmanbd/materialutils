package com.zxdmjr.material_utils

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.Toast

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}


fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT, position: Int = Gravity.BOTTOM){
    val toast = Toast.makeText(this, message, length)
    toast.setGravity(position, 0, 0)
    toast.show()
}

fun AppCompatActivity.findNavController(@IdRes resId: Int) = (supportFragmentManager.findFragmentById(resId) as NavHostFragment).navController

