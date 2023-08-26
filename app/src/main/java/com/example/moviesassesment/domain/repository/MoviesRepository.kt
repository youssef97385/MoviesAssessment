package com.example.moviesassesment.domain.repository

import com.example.moviesassesment.data.remote.dto.movie_detail_dto.MovieDetailResponse
import com.example.moviesassesment.data.remote.dto.movies_list_dto.MovieDto
import com.example.moviesassesment.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(): List<MovieDto>
    suspend fun getMovieById(movieId:Int): MovieDetailResponse

}