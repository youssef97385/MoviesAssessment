package com.example.moviesassesment.domain.model

import com.example.moviesassesment.common.Constants
import com.example.moviesassesment.common.utils.DateFormatter

data class MovieDetail(
    val id: Int,
    val image: String,
    val genresNames: List<String>,
    val originalLanguage: String,
    val overview: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val budget: String,
    val revenue: String,
    val spokenLanguages: List<String>,
    val status: String,
    val runTime: String,
) {
    val imageUrl = "${Constants.IMAGE_URL}$image"
    val formattedDate: String = DateFormatter.getFormattedMonthAndYear(releaseDate)
}