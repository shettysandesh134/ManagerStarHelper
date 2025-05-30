package com.sandeshshetty.core.domain.employee

import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result

/**
 * @author sandeshshetty
 * Created 5/29/25 at {TIME}
 */
interface RemoteDataSource {
    suspend fun getRuns(): Result<List<Employee>, DataError.Network>

    suspend fun postRun(employee: Employee): Result<Employee, DataError.Network>
}