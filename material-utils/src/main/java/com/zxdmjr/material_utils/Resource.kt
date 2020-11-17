package com.zxdmjr.material_utils

sealed class Resource<out T> {
    data class Success<out T>(val data: T): Resource<T>()
    data class Loading(val nothing: Nothing? = null): Resource<Nothing>()
    data class Failed(val message: String): Resource<Nothing>()
}