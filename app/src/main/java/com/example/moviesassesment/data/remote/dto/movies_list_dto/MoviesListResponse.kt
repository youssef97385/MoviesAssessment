package com.example.moviesassesment.data.remote.dto.movies_list_dto
import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    val page: Int,
    val results: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)