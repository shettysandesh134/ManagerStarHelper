package com.sandeshshetty.auth.presentation.register

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

sealed interface RegisterAction{
    data object OnTogglePasswordVisibilityClick: RegisterAction
    data object OnLoginClick: RegisterAction
    data object OnRegisterClick: RegisterAction
}