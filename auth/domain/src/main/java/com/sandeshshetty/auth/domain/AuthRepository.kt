package com.sandeshshetty.auth.domain

import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.EmptyResult

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */
interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String) : EmptyResult<DataError.Network>
    suspend fun isUserLoggedIn(): Boolean
}