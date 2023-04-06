package com.reza.pulsa.application.utils

import java.text.NumberFormat
import java.util.Locale

class Utils {
    fun formatRupiah(number: Double): String {
        val localeID = Locale("in", "ID")
        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }

}