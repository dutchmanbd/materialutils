package com.zxdmjr.material_utils.extensions

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

/**
 * @param message
 * @param length
 * @param position
 * default length is LENGTH_SHORT
 *   @see Toast.LENGTH_SHORT
 *   @see Toast.LENGTH_SHORT
 * default position BOTTOM
 *   @see Gravity.TOP
 *   @see Gravity.BOTTOM
 *   @see Gravity.LEFT
 *   @see Gravity.RIGHT
 *   @see Gravity.CENTER
 *   @see Gravity.CENTER_HORIZONTAL
 *   @see Gravity.CENTER_VERTICAL
 *   @see Gravity.FILL_VERTICAL
 *   @see Gravity.FILL_HORIZONTAL
 *   @see Gravity.FILL
 *   @see Gravity.CLIP_VERTICAL
 *   @see Gravity.CLIP_HORIZONTAL
 *
 */

fun Context.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
    position: Int = Gravity.BOTTOM
) {
    val toast = Toast.makeText(this, message, length)
    toast.setGravity(position, 0, 0)
    toast.show()
}

/**
 * @return true if device is tablet otherwise false
 */
fun Context.isTablet(): Boolean {
    val xlarge = resources
        .configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK == 4
    val large = resources
        .configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK == Configuration.SCREENLAYOUT_SIZE_LARGE
    return xlarge || large
}


/**
 * @param layoutId
 * find navigation controller using param layoutId
 * @return this host's navigation controller
 *
 */
fun AppCompatActivity.findNavController(
    @IdRes layoutId: Int
) = (supportFragmentManager.findFragmentById(layoutId) as NavHostFragment).navController


fun AppCompatActivity.start(intent: Intent) {
    startActivity(intent)
}

fun AppCompatActivity.startAndFinish(intent: Intent) {
    startActivity(
        intent
            .newTask()
            .clearTask()
    )
    finish()
}


