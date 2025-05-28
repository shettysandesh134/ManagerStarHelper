package com.sandeshshetty.home.domain.employee

import com.sandeshshetty.core.domain.employee.DayAvailable
import com.sandeshshetty.core.domain.employee.EmploymentType
import com.sandeshshetty.core.domain.employee.Shift

/**
 * @author sandeshshetty
 * Created 5/23/25 at {TIME}
 */
data class EmployeeUi(
    val employeeId: String,
    val firstName: String,
    val lastName: String,
    val availability: List<DayAvailable> = emptyList(),
    val employmentType: EmploymentType,
    val perDayWorkingHours: Double? = null,
    val phoneNumber: String,
    val dob: String,
    val email: String,
    val shifts: List<Shift> = emptyList()
)
