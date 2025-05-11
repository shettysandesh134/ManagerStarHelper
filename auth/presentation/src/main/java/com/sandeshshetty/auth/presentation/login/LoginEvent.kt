package com.sandeshshetty.auth.presentation.login

import com.sandeshshetty.core.presentation.ui.UiText

/**
 * @author sandeshshetty
 * Created 5/10/25 at {TIME}
 */

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}