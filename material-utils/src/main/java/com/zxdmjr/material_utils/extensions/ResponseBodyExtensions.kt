package com.zxdmjr.material_utils.extensions

import com.google.gson.Gson
import okhttp3.ResponseBody


inline fun <reified T> ResponseBody.toErrorBody(): T?{
    val error: String? = string()
    return if(error == null){
        null
    } else{
        Gson().fromJson(error, T::class.java)
    }
}