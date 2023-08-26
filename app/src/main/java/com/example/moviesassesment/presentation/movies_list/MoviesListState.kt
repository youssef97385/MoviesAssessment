package com.example.moviesassesment.presentation.movies_list

import com.example.moviesassesment.domain.model.Movie

data class MovieListState(
    val isLoading:Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
