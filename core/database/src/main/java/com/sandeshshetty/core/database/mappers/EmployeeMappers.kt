package com.sandeshshetty.core.database.mappers

import com.sandeshshetty.core.database.entity.EmployeeEntity
import com.sandeshshetty.core.domain.employee.DayAvailable
import com.sandeshshetty.core.domain.employee.Employee
import com.sandeshshetty.core.domain.employee.EmploymentType
import com.sandeshshetty.core.domain.util.convertStringToEmploymentType
import com.sandeshshetty.core.domain.util.convertToString
import com.sandeshshetty.core.domain.util.toLocalDate
import org.bson.types.ObjectId
import java.time.DayOfWeek

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */

fun EmployeeEntity.toEmployee(): Employee {
    return Employee(
        employeeId = employeeId,
        firstName = employeeFname,
        lastName = employeeLname,
        dob = dob?.toLocalDate(),
        age = age,
        email = email,
        phoneNumber = phoneNumber,
        employmentType = employmentType.convertStringToEmploymentType(hourlyRate, dailyRate, startTime, endTime),
        dayAvailable = dayAvailable.split(",").map {
            if (it.last() == 'A') {
                DayAvailable(dayOfWeek = DayOfWeek.valueOf(it.dropLast(1).uppercase()), isAvailable = true)
            } else {
                DayAvailable(dayOfWeek = DayOfWeek.valueOf(it.dropLast(1).uppercase()), isAvailable = false)
            }
        }
    )
}

fun Employee.toEmployeeEntity(): EmployeeEntity {
    return EmployeeEntity(
        employeeFname = firstName,
        employeeLname = lastName,
        dob = dob?.convertToString(),
        age = age,
        email = email,
        phoneNumber = phoneNumber,
        employmentType = employmentType.javaClass.simpleName,
        hourlyRate = (employmentType as? EmploymentType.Casual)?.hourlyRate?.toDouble(),
        dailyRate = (employmentType as? EmploymentType.FullTime)?.dailyRate?.toDouble(),
        startTime = (employmentType as? EmploymentType.FullTime)?.startTime,
        endTime = (employmentType as? EmploymentType.FullTime)?.endTime,
        dayAvailable = dayAvailable.joinToString(separator = ",") {
            if (it.isAvailable) {
                "${it.dayOfWeek}A"  // Append 'A' for availability so string will be MondayA,TuesdayA,WednesdayA,ThursdayA,FridayA,SaturdayA,SundayA
            } else {
                "${it.dayOfWeek}N" // Append 'N' for non-availability
            }
        },
        employeeId = employeeId ?: 0
    )
}
