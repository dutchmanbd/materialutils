package com.zxdmjr.material_utils

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


//    val message = StringBuilder()
//    error?.let {
//        try {
//            val errorObject = JSONObject(it)
//            for(key in errorObject.keys()){
//                val errorObject1 = errorObject.getJSONObject(key)
//
//            }
//            if (errorObject.has("error")) {
//                val errorObject1 = errorObject.getJSONObject("error")
//                for (key in errorObject1.keys()) {
//                    message.append(errorObject1.getString(key)).append("\n")
//                }
//            } else {
//                message.append("Unknown error occurred").append("\n")
//            }
//        } catch (e: JSONException) {
//            message.append(e.message).append("\n")
//        }
//    }