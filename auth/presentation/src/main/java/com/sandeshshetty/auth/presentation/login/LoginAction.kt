package com.sandeshshetty.auth.presentation.login

/**
 * @author sandeshshetty
 * Created 5/10/25 at {TIME}
 */
sealed interface LoginAction {
    data object OnTogglePasswordVisibilityClick : LoginAction
    data object OnLoginClick: LoginAction
    data object OnRegisterClick: LoginAction
}