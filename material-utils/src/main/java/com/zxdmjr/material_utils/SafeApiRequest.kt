package com.zxdmjr.material_utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : Resource<T>{
        val response = call.invoke()
        if(response.isSuccessful){
            if(response.body() == null){
                return Resource.Failed("Unknown error occurred")
            }else{
                return Resource.Success(response.body()!!)
            }
        } else{
            val error: String? = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let{
                try{
                    val errorObject = JSONObject(it)
                    if(errorObject.has("error")){
                        val errorObject1 = errorObject.getJSONObject("error")
                        for (key in errorObject1.keys()){
                            message.append(errorObject1.getString(key)).append("\n")
                        }
                    } else{
                        message.append("Unknown error occurred").append("\n")
                    }
                }catch(e: JSONException){
                    message.append(e.message).append("\n")
                }
            }
            return Resource.Failed(message.toString())
        }
    }
}