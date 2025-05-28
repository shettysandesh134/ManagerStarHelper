package com.sandeshshetty.core.domain.employee

import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

/**
 * @author sandeshshetty
 * Created 5/23/25 at {TIME}
 */
data class DayAvailable(
    val dayOfWeek: DayOfWeek,
    val isAvailable: Boolean = false
) {
    val dayOfWeekString: String
        get() = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
}
