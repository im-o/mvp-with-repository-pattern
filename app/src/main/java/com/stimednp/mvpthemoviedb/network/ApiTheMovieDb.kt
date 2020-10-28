package com.stimednp.mvpthemoviedb.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on Oct/28/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface ApiTheMovieDb {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") strLanguage: String
    ): Deferred<Response<Any>>
}