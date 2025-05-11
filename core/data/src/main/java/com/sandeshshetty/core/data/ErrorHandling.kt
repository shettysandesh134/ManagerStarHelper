package com.sandeshshetty.core.data

import android.util.Log
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException
import timber.log.Timber
import java.nio.channels.UnresolvedAddressException

/**
 * @author sandeshshetty
 * Created 5/9/25 at {TIME}
 */

suspend inline fun <T> safeCall(crossinline execute:suspend () -> T): Result<T, DataError.Network> {
    return try {
        val result = execute()
        Result.Success(result)
    }catch (e: Exception) {
        e.toAppError()
    }
}

fun Throwable.toAppError(): Result.Error<DataError.Network> {
    return when(this) {
        is UnresolvedAddressException -> Result.Error(DataError.Network.NO_INTERNET)
        is SerializationException -> Result.Error(DataError.Network.SERIALIZATION_ERROR)

        is FirebaseAuthException -> returnError(this)

        else -> Result.Error(DataError.Network.UNKNOWN)
    }
}

fun returnError(firebaseAuthException: FirebaseAuthException): Result.Error<DataError.Network> {
    Timber.tag("returnError").e(firebaseAuthException.errorCode)
    return when (firebaseAuthException.errorCode) {
        "ERROR_EMAIL_ALREADY_IN_USE" -> Result.Error(DataError.Network.EMAIL_ALREADY_IN_USE)
        "ERROR_USER_NOT_FOUND" -> Result.Error(DataError.Network.USER_NOT_FOUND)
        "ERROR_WRONG_PASSWORD" -> Result.Error(DataError.Network.WRONG_PASSWORD)
        "INVALID_CREDENTIAL" -> Result.Error(DataError.Network.INVALID_CREDENTIALS)
        else -> Result.Error(DataError.Network.UNKNOWN)
    }
}
