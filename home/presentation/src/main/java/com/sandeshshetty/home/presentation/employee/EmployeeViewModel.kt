package com.sandeshshetty.home.presentation.employee

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class EmployeeViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(EmployeeState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = EmployeeState()
        )

    fun onAction(action: EmployeeAction) {
        when (action) {
            is EmployeeAction.OnEmploymentTypeSelection -> {
                _state.value = _state.value.copy(
                    employmentType = action.employmentType
                )
            }
            is EmployeeAction.onEmployeeDayAvailabilityChange -> {
                _state.value = _state.value.copy(
                    dayAvailable = _state.value.dayAvailable.map {
                        if (it.dayOfWeek == action.dayOfWeek) {
                            it.copy(isAvailable = !it.isAvailable)
                        } else {
                            it
                        }
                    }
                )
            }
            is EmployeeAction.onAddEmployeeClick -> {
                _state.value = _state.value.copy(
                    isAddingEmployee = true
                )
            }
            is EmployeeAction.onAddEmployeeDialogClick -> {
                _state.value = _state.value.copy(
                    isEmployeeDialogVisible = !_state.value.isEmployeeDialogVisible
                )
            }
            is EmployeeAction.onDismissAddEmployeeDialog -> {
                _state.value = _state.value.copy(
                    isEmployeeDialogVisible = false
                )
            }
            else -> TODO("Handle actions")
        }
    }

}