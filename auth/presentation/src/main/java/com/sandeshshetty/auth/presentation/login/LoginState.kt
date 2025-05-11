package com.sandeshshetty.auth.presentation.login

import androidx.compose.foundation.text.input.TextFieldState

/**
 * @author sandeshshetty
 * Created 5/10/25 at {TIME}
 */
data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val isLoggingIn: Boolean = false,
    val canLogin: Boolean = false
)
