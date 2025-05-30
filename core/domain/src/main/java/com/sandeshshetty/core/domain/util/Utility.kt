package com.sandeshshetty.core.domain.util

import com.sandeshshetty.core.domain.employee.EmploymentType
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */

fun String.toLocalDate(): LocalDate {
    val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.getDefault())
    return LocalDate.parse(this, df)
}

fun LocalDate.convertToString(): String {
    val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.getDefault())
    return this.format(df)
}

fun String.convertStringToEmploymentType(
    hourlyRate: Double?,
    dailyRate: Double?,
    startTime: String?,
    endTime: String?
): EmploymentType {
    return when (this) {
        "Casual" -> {
            EmploymentType.Casual(hourlyRate!!.toBigDecimal())
        }

        "FullTime" -> {
            EmploymentType.FullTime(dailyRate!!.toBigDecimal(), startTime!!, endTime!!)
        }
        else -> {
            EmploymentType.Casual(BigDecimal(16.0))
        }
    }
}

fun String.toDayOfWeekShort(locale: Locale = Locale.ENGLISH): DayOfWeek? {
    return DayOfWeek.values().firstOrNull() { day ->
        day.getDisplayName(TextStyle.SHORT, locale).equals(this, ignoreCase = true)
    }
}