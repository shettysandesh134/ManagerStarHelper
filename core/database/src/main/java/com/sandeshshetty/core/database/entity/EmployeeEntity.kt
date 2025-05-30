package com.sandeshshetty.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.bson.types.ObjectId

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */

@Entity
data class EmployeeEntity(
    val employeeFname: String,
    val employeeLname: String,
    val dob: String?,
    val age: Int?,
    val email: String?,
    val phoneNumber: String?,
    val employmentType: String,
    val hourlyRate: Double?,
    val dailyRate: Double?,
    val startTime: String?,
    val endTime: String?,
    val dayAvailable: String,
    @PrimaryKey(autoGenerate = true)
    val employeeId: Int = 0
)
