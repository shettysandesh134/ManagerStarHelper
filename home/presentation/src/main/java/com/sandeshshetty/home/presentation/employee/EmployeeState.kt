package com.sandeshshetty.home.presentation.employee

import androidx.compose.foundation.text.input.TextFieldState
import com.sandeshshetty.core.domain.employee.DayAvailable
import com.sandeshshetty.core.domain.employee.EmploymentType
import com.sandeshshetty.core.domain.employee.util.EmployeeConstants
import com.sandeshshetty.home.domain.employee.EmployeeUi
import java.math.BigDecimal
import java.time.DayOfWeek

data class EmployeeState(
    val employees: List<EmployeeUi> = emptyList(),
    val fname: TextFieldState = TextFieldState(),
    val lname: TextFieldState = TextFieldState(),
    val phoneNumber: TextFieldState = TextFieldState(),
    val employmentType: EmploymentType = EmploymentType.Casual(BigDecimal(EmployeeConstants.CASUAL_EMPLOYEE_HOUR_RATE)),
//    val employmentType: EmploymentType = EmploymentType.FullTime(BigDecimal(EmployeeConstants.FULLTIME_EMPLOYEE_DAILY_RATE), EmployeeConstants.FULLTIME_EMPLOYEE_START_TIME, EmployeeConstants.FULLTIME_EMPLOYEE_END_TIME),
    val hourlyRate: TextFieldState = TextFieldState(),
    val dailyRate: TextFieldState = TextFieldState(),
    val startTime: TextFieldState = TextFieldState(),
    val endTime: TextFieldState = TextFieldState(),
    val isEmployeeDialogVisible: Boolean = false,
    val isAddingEmployee: Boolean = false,
    val canAddEmployee: Boolean = false,
    val dayAvailable: List<DayAvailable> = listOf(
        DayAvailable(dayOfWeek = DayOfWeek.MONDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.TUESDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.WEDNESDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.THURSDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.FRIDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.SATURDAY, isAvailable = false),
        DayAvailable(dayOfWeek = DayOfWeek.SUNDAY, isAvailable = false),
    )
)