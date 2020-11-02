package com.stimednp.mvpthemoviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.mvpthemoviedb.BuildConfig
import com.stimednp.mvpthemoviedb.data.model.Movie
import com.stimednp.mvpthemoviedb.databinding.ActivityMainBinding
import com.stimednp.mvpthemoviedb.repository.MovieRepository
import com.stimednp.mvpthemoviedb.util.gone
import com.stimednp.mvpthemoviedb.util.loge
import com.stimednp.mvpthemoviedb.util.visible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MovieContract.View {
    @Inject lateinit var repository: MovieRepository //only this and it's ready to be used, MAGIC!! :)
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MovieContract.Presenter
    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MoviePresenter(this, repository)
        initView()
        initData()
    }

    private fun initView() {
        binding.movieRV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }

    private fun initData() {

        /**
         * This is just example, how to set args if
         * We can also not use parameter on constructor getMovies(BuildConfig.API_KEY, "en-US")
         * Just set BuildConfig.API_KEY, "en-US" to constant ApiService (ApiTheMovieDb)
         */

        binding.loadingPB.visible()
        presenter.getMovies(BuildConfig.API_KEY, "en-US")
    }

    override fun setItemToView(movies: MutableList<Movie>) {

        /**
         * This function override from MovieContract.View
         * When MoviePresenter get data from MovieRepository, MoviePresenter pass result data to setItemToView()
         */

        binding.loadingPB.gone()
        movieAdapter.clearMovies()
        movieAdapter.setMovies(movies)
    }

    override fun setError(throwable: Throwable) {
        binding.loadingPB.gone()
        loge(throwable.message.toString())
    }

    override fun setPresenter(presenter: MovieContract.Presenter) {
        this.presenter = presenter
    }
}