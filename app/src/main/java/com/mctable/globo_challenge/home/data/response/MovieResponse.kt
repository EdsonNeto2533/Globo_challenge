package com.mctable.globo_challenge.home.data.response

import com.google.gson.annotations.SerializedName
import com.mctable.globo_challenge.commons.utils.Constants

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_title")
    val movieName: String
) {
    fun getPostUrl() : String {
        return Constants.IMAGE_PATH + posterPath
    }
}
