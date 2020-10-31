package com.stimednp.mvpthemoviedb.ui

import com.stimednp.mvpthemoviedb.data.model.Movie
import com.stimednp.mvpthemoviedb.repository.MovieDataSource
import com.stimednp.mvpthemoviedb.repository.MovieRepository

/**
 * Created by rivaldy on Oct/29/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MoviePresenter(
    private val view: MovieContract.View,
    private val repository: MovieRepository
) : MovieContract.Presenter {

    init {

        /**
         * When View (activity etc) instantiation class MoviePresenter
         * Init function this.view.setPresenter(this) on init to set Presenter
         */

        this.view.setPresenter(this)
    }

    override fun getMovies(apiKey: String, strLanguage: String) {

        /**
         * This function override from MovieContract.Presenter
         * And calling function from repository.getMovies()
         */

        repository.getMovies(apiKey, strLanguage, object : MovieDataSource.LoadMoviesCallback {
            override fun onDataLoaded(movies: MutableList<Movie>) {

                /**
                 * When MovieRepository pass onDataLoaded()
                 * This function will be pass data to View, using function setItemToView()
                 */

                view.setItemToView(movies)
            }

            override fun onError(throwable: Throwable) {
                view.setError(throwable)
            }
        })
    }

    override fun start() {

        /**
         * Call function here, like loadData() etc and call this function start() from View.
         * And now, i don't needed this function, but let override it (only for sample using BasePresenter)
         * Maybe you can use this function to checked data or more (What i am do when app launch).
         */

    }
}