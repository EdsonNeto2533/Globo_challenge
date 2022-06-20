package com.mctable.globo_challenge.home.data.response

import com.google.gson.annotations.SerializedName
import com.mctable.globo_challenge.commons.utils.Constants

sealed class MoviesUIState {
    object Loading : MoviesUIState()

    class Success(val moviesList: List<MovieResponse>) : MoviesUIState()
}

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
