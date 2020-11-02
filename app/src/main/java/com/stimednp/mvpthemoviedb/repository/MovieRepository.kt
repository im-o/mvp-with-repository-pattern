package com.stimednp.mvpthemoviedb.repository

import com.stimednp.mvpthemoviedb.data.model.Movie
import javax.inject.Inject

/**
 * Created by rivaldy on Oct/28/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieRepository @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieDataSource {

    override fun getMovies(apiKey: String, strLanguage: String, callback: MovieDataSource.LoadMoviesCallback) {

        /**
         * This function override from MovieDataSource
         * And calling function from movieRemoteDataSource.getMovies()
         * When MovieRemoteDataSource pass callback.onDataLoaded() this function send callback again to MoviePresenter
         */

        movieRemoteDataSource.getMovies(apiKey, strLanguage, object : MovieDataSource.LoadMoviesCallback {
            override fun onDataLoaded(movies: MutableList<Movie>) {

                /**
                 * When MovieRemoteDataSource pass callback.onDataLoaded()
                 * This function pass/send callback again to MoviePresenter
                 */

                callback.onDataLoaded(movies)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }
        })
    }
}