package com.zxdmjr.material_utils.extensions


import android.app.Activity
import androidx.activity.result.ActivityResult


inline fun ActivityResult.checkResultAndExecute(block: ActivityResult.() -> Unit) =
    if (resultCode == Activity.RESULT_OK) runCatching(block)
    else Result.failure(Exception("Something went wrong"))