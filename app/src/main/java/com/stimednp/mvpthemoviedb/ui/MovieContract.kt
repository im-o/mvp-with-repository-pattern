package com.stimednp.mvpthemoviedb.ui

import com.stimednp.mvpthemoviedb.BasePresenter
import com.stimednp.mvpthemoviedb.BaseView
import com.stimednp.mvpthemoviedb.data.model.Movie

/**
 * Created by rivaldy on Oct/29/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieContract {

    interface View : BaseView<Presenter> {

        /**
         * Add more function View here to show on View like Activity, Fragment or Dialog
         * You can also not use BaseView if you don't need it
         */

        fun setItemToView(movies: MutableList<Movie>)
        fun setError(throwable: Throwable)
    }

    interface Presenter : BasePresenter {

        /**
         * Add more function Presenter here to set/get data
         * You can also not use BasePresenter if you don't need it
         */

        fun getMovies(apiKey: String, strLanguage: String)
    }
}