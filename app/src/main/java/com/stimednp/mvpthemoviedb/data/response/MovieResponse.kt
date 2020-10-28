package com.stimednp.mvpthemoviedb.data.response


import com.google.gson.annotations.SerializedName
import com.stimednp.mvpthemoviedb.data.model.Movie

data class MovieResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: MutableList<Movie>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)