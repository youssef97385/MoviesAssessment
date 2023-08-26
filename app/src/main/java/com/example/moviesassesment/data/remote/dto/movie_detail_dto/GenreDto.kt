package com.example.moviesassesment.data.remote.dto.movie_detail_dto

data class GenreDto(
    val id: Int,
    val name: String,
)

fun GenreDto.toGenreName() :String{
    return name;
}