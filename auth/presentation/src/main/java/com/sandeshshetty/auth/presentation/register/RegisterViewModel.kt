package com.sandeshshetty.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sandeshshetty.auth.domain.AuthRepository
import com.sandeshshetty.auth.domain.UserDataValidator
import com.sandeshshetty.auth.presentation.R
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result
import com.sandeshshetty.core.presentation.ui.UiText
import com.sandeshshetty.core.presentation.ui.asUiText
import com.sandeshshetty.core.presentation.ui.testAsFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */
class RegisterViewModel(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository
) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    private val _eventChannel = Channel<RegisterEvent>()
    val eventChannel = _eventChannel.receiveAsFlow()

    init {
        state.email.testAsFlow()
            .onEach { email ->
                val isValidEmail = userDataValidator.isValidEmail(email.toString())
                state = state.copy(
                    isEmailValid = isValidEmail,
                    canRegister = isValidEmail && state.passwordValidationState.isValidPassword
                            && !state.isRegistering
                )
            }
            .launchIn(viewModelScope)

        state.password.testAsFlow()
            .onEach { password ->
                val passwordValidationState =
                    userDataValidator.validatePassword(password.toString())
                state = state.copy(
                    passwordValidationState = passwordValidationState,
                    canRegister = state.isEmailValid && passwordValidationState.isValidPassword
                            && !state.isRegistering
                )
            }
            .launchIn(viewModelScope)
    }

    fun onAction(action: RegisterAction) {
        when (action) {
            RegisterAction.OnRegisterClick -> register()
            RegisterAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(
                    isPasswordVisible = !state.isPasswordVisible
                )
            }
            else -> Unit
        }
    }

    private fun register() {
        viewModelScope.launch {
            state = state.copy(isRegistering = true)
            val result = authRepository.register(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isRegistering = false)

            when (result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.UNKNOWN) {
                        _eventChannel.send(RegisterEvent.Error(UiText.StringResource(R.string.unknown_error)))
                    }else {
                        _eventChannel.send(RegisterEvent.Error(result.error.asUiText()))
                    }
                }
                is Result.Success -> {
                    _eventChannel.send(RegisterEvent.RegistrationSuccess)
                }
            }
        }
    }
}
