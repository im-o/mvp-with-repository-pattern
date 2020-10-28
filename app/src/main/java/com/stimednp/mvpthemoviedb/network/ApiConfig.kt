package com.stimednp.mvpthemoviedb.network

import com.google.gson.GsonBuilder
import com.stimednp.mvpthemoviedb.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rivaldy on Oct/28/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class ApiConfig {
    private fun doRequest(): Retrofit {
        val gson = GsonBuilder().create()
        val loggingInterceptor =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun apiTheMovie(): ApiTheMovieDb{
        return doRequest().create(ApiTheMovieDb::class.java)
    }
}