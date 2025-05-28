package com.sandeshshetty.core.domain.employee

import com.sandeshshetty.core.domain.employee.util.EmployeeConstants
import java.math.BigDecimal

/**
 * @author sandeshshetty
 * Created 5/23/25 at {TIME}
 */
sealed class EmploymentType {
    data class Casual(val hourlyRate: BigDecimal): EmploymentType()
    data class FullTime(val dailyRate: BigDecimal, val startTime: String, val endTime: String): EmploymentType()

    companion object {
        val employmentOptions = listOf(
            Casual(BigDecimal(EmployeeConstants.CASUAL_EMPLOYEE_HOUR_RATE)),
            FullTime(
                BigDecimal(EmployeeConstants.FULLTIME_EMPLOYEE_DAILY_RATE),
                EmployeeConstants.FULLTIME_EMPLOYEE_START_TIME,
                EmployeeConstants.FULLTIME_EMPLOYEE_END_TIME
            )
        )
    }
}