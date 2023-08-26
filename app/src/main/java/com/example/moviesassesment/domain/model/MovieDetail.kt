package com.example.moviesassesment.domain.model

import com.example.moviesassesment.common.Constants
import com.example.moviesassesment.common.utils.DateFormatter
import com.example.moviesassesment.common.utils.MoneyFormatter

data class MovieDetail(
    val id: Int,
    val image: String,
    val genresNames: List<String>,
    val originalLanguage: String,
    val overview: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val budget: Int,
    val revenue: Int,
    val spokenLanguages: List<String>,
    val status: String,
    val runTime: Int,
) {
    val imageUrl = "${Constants.IMAGE_URL}$image"
    val formattedDate: String = DateFormatter.getFormattedMonthAndYear(releaseDate)
    val formattedRevenue = MoneyFormatter.formatMoney(revenue)
    val formattedBudget = MoneyFormatter.formatMoney(budget)
}