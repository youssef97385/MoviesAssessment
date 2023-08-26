package com.example.moviesassesment.presentation.movie_detail

import com.example.moviesassesment.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movie: MovieDetail? = null,
    val error: String = "",
)
