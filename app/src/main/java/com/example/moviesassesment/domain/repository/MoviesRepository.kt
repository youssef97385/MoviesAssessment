package com.example.moviesassesment.domain.repository

import com.example.moviesassesment.data.remote.dto.movies_list_dto.MovieDto

interface MovieRepository {
    suspend fun getMovies(): List<MovieDto>

}