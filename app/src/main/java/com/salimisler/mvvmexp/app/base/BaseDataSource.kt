package com.salimisler.mvvmexp.app.base

import android.util.Log
import com.salimisler.mvvmexp.app.utils.Resource
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> getResult(
        call: suspend () -> Response<T>
    ): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    Log.d("data", body.toString())
                    return Resource.success(body)
                }
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }

}