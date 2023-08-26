package com.example.moviesassesment.data.remote.dto.movie_detail_dto

import com.google.gson.annotations.SerializedName

data class SpokenLanguageDto(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso: String,
    val name: String
)