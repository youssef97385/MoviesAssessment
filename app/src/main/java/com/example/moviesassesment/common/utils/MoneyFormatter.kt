package com.example.moviesassesment.common.utils

import java.text.NumberFormat
import java.util.Locale

object MoneyFormatter {
    fun formatMoney(revenue: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale.getDefault())

        val scaledRevenue = revenue / 1_000_000.0

        return format.format(scaledRevenue)
    }
}