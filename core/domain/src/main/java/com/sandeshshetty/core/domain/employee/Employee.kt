package com.sandeshshetty.core.domain.employee

import java.math.BigDecimal
import java.time.LocalDate

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */
data class Employee(
    val employeeId: Int?,
    val firstName: String,
    val lastName: String,
    val dob: LocalDate?,
    val age: Int?,
    val email: String?,
    val phoneNumber: String?,
    val employmentType: EmploymentType,
//    val hourlyRate: BigDecimal? = BigDecimal(0.0),
//    val dailyRate: BigDecimal? = BigDecimal(0.0),
//    val startTime: String?,
//    val endTime: String?,
    val dayAvailable: List<DayAvailable>
)
