package com.stimednp.mvpthemoviedb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stimednp.mvpthemoviedb.data.model.Movie
import com.stimednp.mvpthemoviedb.databinding.ItemMovieBinding

/**
 * Created by rivaldy on Oct/02/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: MutableList<Movie> = mutableListOf()

    fun setMovies(movies: MutableList<Movie>) {
        this.movies = movies
        this.notifyDataSetChanged()
    }

    fun clearMovies() {
        notifyItemRangeRemoved(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movies[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(
        private val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(movie: Movie?) {
            val strUrlImg = "https://image.tmdb.org/t/p/w220_and_h330_face${movie?.posterPath}"
            val strTitle = movie?.originalTitle
            val strDesc = movie?.overview
            val strVote = movie?.voteAverage.toString()

            binding.apply {
                titleTV.text = strTitle
                overviewTV.text = strDesc
                voteTV.text = strVote
                Picasso.get()
                    .load(strUrlImg)
                    .into(posterIV)
            }
        }
    }
}