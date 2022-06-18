package com.mctable.globo_challenge.commons.utils

import retrofit2.Response

abstract class ValidateResponse {

    fun <T> checkResponse(response: Response<T>): T? {
        return if (response.isSuccessful) {
            response.body()
        } else
            null
    }
}