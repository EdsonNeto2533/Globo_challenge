package com.mctable.globo_challenge.moviedetails.data.response

import com.google.gson.annotations.SerializedName
import com.mctable.globo_challenge.commons.utils.Constants

data class MovieDetailsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("genres")
    val genres: List<GenresResponse>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionsCountriesResponse>
) {
    fun getPostUrl(): String {
        return Constants.IMAGE_PATH + posterPath
    }
}

data class GenresResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

data class ProductionsCountriesResponse(
    @SerializedName("name")
    val name: String
)
