package com.sandeshshetty.home.presentation.employee

import com.sandeshshetty.core.domain.employee.EmploymentType
import java.time.DayOfWeek

sealed interface EmployeeAction {
    data class OnEmployeeClick(val employeeId: String): EmployeeAction
    data object onAddEmployeeClick: EmployeeAction
    data object onAddEmployeeDialogClick: EmployeeAction
    data object onDismissAddEmployeeDialog: EmployeeAction
    data class OnEmploymentTypeSelection(val employmentType: EmploymentType): EmployeeAction
    data class onEmployeeDayAvailabilityChange(val dayOfWeek: DayOfWeek): EmployeeAction
}