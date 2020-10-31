package com.stimednp.mvpthemoviedb.network

import com.stimednp.mvpthemoviedb.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on Oct/28/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface ApiTheMovieDb {
    @GET("discover/movie")
    suspend fun getMovieAsync(
        @Query("api_key") apiKey: String,
        @Query("language") strLanguage: String
    ): MovieResponse
}