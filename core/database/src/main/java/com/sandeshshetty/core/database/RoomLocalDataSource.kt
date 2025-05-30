package com.sandeshshetty.core.database

import android.database.sqlite.SQLiteFullException
import com.sandeshshetty.core.database.dao.EmployeeDao
import com.sandeshshetty.core.database.mappers.toEmployee
import com.sandeshshetty.core.database.mappers.toEmployeeEntity
import com.sandeshshetty.core.domain.employee.Employee
import com.sandeshshetty.core.domain.employee.LocalDataSource
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author sandeshshetty
 * Created 5/29/25 at {TIME}
 */
class RoomLocalDataSource(
    private val employeeDao: EmployeeDao
) : LocalDataSource {

    override fun getEmployees(): Flow<List<Employee>> {
        return employeeDao.getEmployees().map { employees ->
            employees.map { employeeEntity ->
                employeeEntity.toEmployee()
            }
        }
    }

    override suspend fun upsertEmployee(employee: Employee): Result<Int, DataError.Local> {
        return try {
            val employeeEntity = employee.toEmployeeEntity()
            employeeDao.upsertEmployee(employeeEntity)
            Result.Success(employeeEntity.employeeId)
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}