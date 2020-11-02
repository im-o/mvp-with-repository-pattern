package com.stimednp.mvpthemoviedb.repository

import com.stimednp.mvpthemoviedb.network.ApiTheMovieDb
import com.stimednp.mvpthemoviedb.util.Coroutines
import javax.inject.Inject

/**
 * Created by rivaldy on Oct/29/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

/**
 * Put all your code here, related to the internet/remote.
 */

class MovieRemoteDataSource @Inject constructor(
    private val apiTheMovieDb: ApiTheMovieDb
) : MovieDataSource {

    override fun getMovies(apiKey: String, strLanguage: String, callback: MovieDataSource.LoadMoviesCallback) {

        /**
         * This function override from MovieDataSource
         * Calling function from apiTheMovieDb.getMovieAsync()
         * And we using Coroutines to Async when fetch data api
         *
         * When fetching data and nothing error (here we using Retrofit, see variable movieResponse)
         * Pass results data movieResponse to Repository using function from interface MovieDataSource.LoadMoviesCallback
         */

        Coroutines.main {
            try {
                val movieResponse = apiTheMovieDb.getMovieAsync(apiKey, strLanguage)
                val movies = movieResponse.results
                callback.onDataLoaded(movies ?: return@main)
            } catch (e: Exception) {
                callback.onError(e)
            }
        }
    }
}