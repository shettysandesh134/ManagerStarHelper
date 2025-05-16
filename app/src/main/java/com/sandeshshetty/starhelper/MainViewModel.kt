package com.sandeshshetty.starhelper

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandeshshetty.auth.domain.AuthRepository
import kotlinx.coroutines.launch

/**
 * @author sandeshshetty
 * Created 5/16/25 at {TIME}
 */
class MainViewModel(
    private val authRepository: AuthRepository
): ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                isCheckingAuth = true
            )
            state = state.copy(
                isLoggedIn = authRepository.isUserLoggedIn()
            )
            state = state.copy(
                isCheckingAuth = false
            )
        }
    }

}