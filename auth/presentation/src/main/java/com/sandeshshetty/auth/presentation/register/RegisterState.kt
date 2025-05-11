package com.sandeshshetty.auth.presentation.register


import androidx.compose.foundation.text.input.TextFieldState
import com.sandeshshetty.auth.domain.PasswordValidationState

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

data class RegisterState(
    val email: TextFieldState = TextFieldState(),
    val isEmailValid: Boolean = false,
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    val isRegistering: Boolean = false,
    val canRegister: Boolean = false
)