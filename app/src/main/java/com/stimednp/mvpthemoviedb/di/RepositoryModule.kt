package com.stimednp.mvpthemoviedb.di

import com.stimednp.mvpthemoviedb.network.ApiTheMovieDb
import com.stimednp.mvpthemoviedb.repository.MovieRemoteDataSource
import com.stimednp.mvpthemoviedb.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * Created by rivaldy on Nov/02/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun providesMovieRemoteDataSource(apiTheMovieDb: ApiTheMovieDb): MovieRemoteDataSource {
        return MovieRemoteDataSource(apiTheMovieDb)
    }

    @Provides
    fun providesMovieRepository(movieRemoteDataSource: MovieRemoteDataSource) : MovieRepository {
        return MovieRepository(movieRemoteDataSource)
    }
}