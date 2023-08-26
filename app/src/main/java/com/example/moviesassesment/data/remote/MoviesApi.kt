package com.example.moviesassesment.data.remote

import com.example.moviesassesment.data.remote.dto.movies_list_dto.MoviesListResponse
import retrofit2.http.GET

interface MoviesApi {

    @GET("discover/movie")
    suspend fun getMovies(): MoviesListResponse

}