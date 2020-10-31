package com.stimednp.mvpthemoviedb.repository

import com.stimednp.mvpthemoviedb.data.model.Movie

/**
 * Created by rivaldy on Oct/28/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface MovieDataSource {

    /**
     * Add more function set/get data here.
     * And add more interface here if you need to pass/send callback when function got complete/failure like getMovies()
     * You can impl this interface on Repository, RemoteDataSource (MovieRepository, MovieRemoteDataSource)
     */

    fun getMovies(apiKey: String, strLanguage: String, callback: LoadMoviesCallback)

    interface LoadMoviesCallback {
        fun onDataLoaded(movies: MutableList<Movie>)
        fun onError(throwable: Throwable)
    }
}