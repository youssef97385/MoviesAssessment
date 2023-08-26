package com.example.moviesassesment.data.repository

import com.example.moviesassesment.data.remote.MoviesApi
import com.example.moviesassesment.data.remote.dto.movies_list_dto.MovieDto
import com.example.moviesassesment.data.remote.dto.movies_list_dto.MoviesListResponse
import com.example.moviesassesment.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApi,
) : MovieRepository {
    override suspend fun getMovies(): List<MovieDto> {
        val  moviesResponse :MoviesListResponse= api.getMovies()
        return moviesResponse.results
    }

}