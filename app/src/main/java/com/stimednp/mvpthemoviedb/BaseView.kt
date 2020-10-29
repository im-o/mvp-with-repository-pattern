package com.stimednp.mvpthemoviedb

/**
 * Created by rivaldy on Oct/29/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}