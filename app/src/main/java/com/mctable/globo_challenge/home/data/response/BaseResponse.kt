package com.mctable.globo_challenge.home.data.response

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResponse>
)
