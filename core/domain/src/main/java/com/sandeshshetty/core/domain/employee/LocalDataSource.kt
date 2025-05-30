package com.sandeshshetty.core.domain.employee

import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

/**
 * @author sandeshshetty
 * Created 5/29/25 at {TIME}
 */
interface LocalDataSource {
    fun getEmployees(): Flow<List<Employee>>
    suspend fun upsertEmployee(employee: Employee): Result<Int, DataError.Local>
}