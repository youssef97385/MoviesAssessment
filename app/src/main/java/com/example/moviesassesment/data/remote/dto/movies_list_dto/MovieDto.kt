package com.example.moviesassesment.data.remote.dto.movies_list_dto

import com.example.moviesassesment.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDto(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        id,
        adult,
        backdropPath,
        genreIds,
        originalLanguage,
        overview,
        popularity,
        posterPath,
        releaseDate,
        title,
        voteAverage
    )
}