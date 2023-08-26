package com.example.moviesassesment.di

import com.example.moviesassesment.common.Constants.BASE_URL
import com.example.moviesassesment.data.remote.HeaderInterceptor
import com.example.moviesassesment.data.remote.MoviesApi
import com.example.moviesassesment.data.repository.MovieRepositoryImpl
import com.example.moviesassesment.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesMoviesApi(): MoviesApi {

        val client = OkHttpClient.Builder().apply {
            addInterceptor(HeaderInterceptor())
        }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }


}