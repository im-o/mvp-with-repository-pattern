package com.stimednp.mvpthemoviedb.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.stimednp.mvpthemoviedb.BuildConfig
import com.stimednp.mvpthemoviedb.network.ApiTheMovieDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rivaldy on Nov/02/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesBaseURL(): String {
        return BuildConfig.BASE_URL
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    @Provides
    fun providesOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    fun providesConvertFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun providesRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun providesRetrofit(
        baseURL: String,
        converterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesAPIService(retrofit: Retrofit): ApiTheMovieDb {
        return retrofit.create(ApiTheMovieDb::class.java)
    }
}