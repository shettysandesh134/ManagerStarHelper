package com.sandeshshetty.auth.presentation.register

import com.sandeshshetty.core.presentation.ui.UiText

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent
}