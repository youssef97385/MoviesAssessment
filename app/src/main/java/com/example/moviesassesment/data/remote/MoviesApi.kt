package com.example.moviesassesment.data.remote

import com.example.moviesassesment.data.remote.dto.movie_detail_dto.MovieDetailResponse
import com.example.moviesassesment.data.remote.dto.movies_list_dto.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("discover/movie")
    suspend fun getMovies(): MoviesListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int):MovieDetailResponse

}