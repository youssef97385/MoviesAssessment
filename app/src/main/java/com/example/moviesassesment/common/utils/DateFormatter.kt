package com.example.moviesassesment.common.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object DateFormatter {

    fun getYearFromFullDate(fullDate: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(fullDate, formatter)
        return date.year.toString()
    }

    fun getFormattedMonthAndYear(fullDate: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(fullDate, formatter)

        val month = date.month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
        val year = date.year

        return "$month $year"
    }
}