package com.sandeshshetty.home.data.employee

import com.sandeshshetty.core.domain.employee.Employee
import com.sandeshshetty.core.domain.employee.RemoteDataSource
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result

/**
 * @author sandeshshetty
 * Created 5/29/25 at {TIME}
 */
class FirestoreRemoteDataSource: RemoteDataSource {
    override suspend fun getRuns(): Result<List<Employee>, DataError.Network> {
        TODO("Not yet implemented")
    }

    override suspend fun postRun(employee: Employee): Result<Employee, DataError.Network> {
        TODO("Not yet implemented")
    }
}