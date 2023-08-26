package com.example.moviesassesment.common.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateFormatter {

    fun getYearFromFullDate(fullDate: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(fullDate, formatter)
        return date.year.toString()
    }
}