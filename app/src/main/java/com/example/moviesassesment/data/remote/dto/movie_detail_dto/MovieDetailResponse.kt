package com.example.moviesassesment.data.remote.dto.movie_detail_dto

import com.example.moviesassesment.data.remote.dto.movies_list_dto.MovieDto
import com.example.moviesassesment.domain.model.Movie
import com.example.moviesassesment.domain.model.MovieDetail
import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any,
    val budget: Int,
    val genres: List<GenreDto>,
    val homepage: String,
    val id: Int,
    @SerializedName("imdb_id")
    val imdbId: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyDto>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryDto>,
    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguageDto>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
)

fun MovieDetailResponse.toMovieDetail(): MovieDetail {
    return MovieDetail(
        id,
        backdropPath,
        genres.map { it.name },
        originalLanguage,
        overview,
        releaseDate,
        title,
        voteAverage,
        budget,
        revenue,spokenLanguages.map { it.englishName },status, runtime
    )
}