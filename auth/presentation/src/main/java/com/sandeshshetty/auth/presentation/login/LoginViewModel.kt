package com.sandeshshetty.auth.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandeshshetty.auth.domain.AuthRepository
import com.sandeshshetty.auth.domain.UserDataValidator
import com.sandeshshetty.auth.presentation.R
import com.sandeshshetty.auth.presentation.register.RegisterEvent
import com.sandeshshetty.core.domain.util.DataError
import com.sandeshshetty.core.domain.util.Result
import com.sandeshshetty.core.presentation.ui.UiText
import com.sandeshshetty.core.presentation.ui.asUiText
import com.sandeshshetty.core.presentation.ui.testAsFlow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * @author sandeshshetty
 * Created 5/10/25 at {TIME}
 */
class LoginViewModel(
    private val authRepository: AuthRepository,
    private val userDataValidator: UserDataValidator
): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val _eventChannel = Channel<LoginEvent>()
    val events = _eventChannel.receiveAsFlow()

    init {
        combine(state.email.testAsFlow(), state.password.testAsFlow()) { email, password ->
            state = state.copy(
                canLogin = userDataValidator.isValidEmail(
                    email = email.toString().trim()
                ) && password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnLoginClick -> {
                login()
            }
            is LoginAction.OnTogglePasswordVisibilityClick -> {
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)
            }
            else -> Unit
        }
    }

    private fun login() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)
            val result = authRepository.login(email = state.email.text.toString().trim(), password = state.password.text.toString())
            state = state.copy(isLoggingIn = false)

            when (result) {
                is com.sandeshshetty.core.domain.util.Result.Error -> {
                    if (result.error == DataError.Network.UNKNOWN) {
                        _eventChannel.send(LoginEvent.Error(UiText.StringResource(R.string.unknown_error)))
                    }else {
                        _eventChannel.send(LoginEvent.Error(result.error.asUiText()))
                    }
                }
                is Result.Success -> {
                    _eventChannel.send(LoginEvent.LoginSuccess)
                }
            }
        }

    }
}