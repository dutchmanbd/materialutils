package com.zxdmjr.material_utils

import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): Resource<T> {
        val response = call.invoke()
        return if (response.isSuccessful) {
            if (response.body() != null) {
                Resource.Success(response.body()!!)
            } else {
                Resource.Failed(null, "Unknown error occurred")
            }
        } else {
            val errorBody = response.errorBody()
            Resource.Failed(errorBody, "")
        }
    }
}