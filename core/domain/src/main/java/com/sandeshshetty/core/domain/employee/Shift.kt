package com.sandeshshetty.core.domain.employee

import java.time.LocalDate

/**
 * @author sandeshshetty
 * Created 5/23/25 at {TIME}
 */
data class Shift(
    val shiftId: String,
    val employeeId: String,
    val date: LocalDate,
    val startTime: String,
    val endTime: String,

)
