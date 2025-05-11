package com.sandeshshetty.core.presentation.ui

import com.sandeshshetty.core.domain.util.DataError

/**
 * @author sandeshshetty
 * Created 5/9/25 at {TIME}
 */
fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Network.EMAIL_ALREADY_IN_USE -> UiText.StringResource(R.string.email_already_in_use)
        DataError.Network.NO_INTERNET -> UiText.StringResource(R.string.no_internet)
        DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.server_error)
        DataError.Network.UNAUTHORIZED -> UiText.StringResource(R.string.unauthorized)
        DataError.Network.SERIALIZATION_ERROR -> UiText.StringResource(R.string.serialisation_error)
        DataError.Network.INVALID_CREDENTIALS -> UiText.StringResource(R.string.invalid_credentials)
        DataError.Network.WRONG_PASSWORD -> UiText.StringResource(R.string.wrong_password)
        DataError.Network.USER_NOT_FOUND -> UiText.StringResource(R.string.user_not_found)
        else -> UiText.StringResource(R.string.unknown)
    }
}