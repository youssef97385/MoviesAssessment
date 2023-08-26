package com.example.moviesassesment.domain.model

import com.example.moviesassesment.common.utils.DateFormatter


data class Movie(
    val id: Int,
    val adult: Boolean,
    val image: String,
    val genreIds: List<Int>,
    val originalLanguage: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
) {
    val year: String = DateFormatter.getYearFromFullDate(releaseDate)
}