package com.sandeshshetty.core.presentation.ui

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.snapshotFlow

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

fun TextFieldState.testAsFlow() = snapshotFlow { text }