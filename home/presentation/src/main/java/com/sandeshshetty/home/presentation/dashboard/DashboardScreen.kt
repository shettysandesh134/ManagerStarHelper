@file:OptIn(ExperimentalMaterial3Api::class)

package com.sandeshshetty.home.presentation.dashboard

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sandeshshetty.core.presentationdesignsystem.LogoIcon
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperBottomBar
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperScaffold
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperToolbar
import com.sandeshshetty.home.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun DashboardRoot(
    viewModel: DashboardViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DashboardScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun DashboardScreen(
    state: DashboardState,
    onAction: (DashboardAction) -> Unit,
) {
    Text(text = "Dashboard Screen1")
}

@Preview
@Composable
private fun Preview() {
    StarHelperTheme {
        DashboardScreen(
            state = DashboardState(),
            onAction = {}
        )
    }
}