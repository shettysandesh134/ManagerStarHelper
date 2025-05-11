package com.sandeshshetty.core.domain.util

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

sealed interface DataError : Error {

    enum class Network : DataError {
        NO_INTERNET,
        UNKNOWN,
        SERVER_ERROR,
        UNAUTHORIZED,
        SERIALIZATION_ERROR,
        EMAIL_ALREADY_IN_USE,
        INVALID_CREDENTIALS,
        USER_NOT_FOUND,
        WRONG_PASSWORD
    }
}