package com.sandeshshetty.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.sandeshshetty.core.database.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow

/**
 * @author sandeshshetty
 * Created 5/28/25 at {TIME}
 */

@Dao
interface EmployeeDao {

    @Upsert
    suspend fun upsertEmployee(employeeEntity: EmployeeEntity)

    @Query("SELECT * FROM employeeentity")
    fun getEmployees(): Flow<List<EmployeeEntity>>

}