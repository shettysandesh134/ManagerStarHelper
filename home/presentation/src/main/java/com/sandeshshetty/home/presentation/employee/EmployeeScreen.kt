@file:OptIn(ExperimentalMaterial3Api::class)

package com.sandeshshetty.home.presentation.employee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.GradientBackground
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperActionButton
import com.sandeshshetty.home.presentation.employee.component.AddEmployeeDialog
import com.sandeshshetty.home.presentation.employee.component.EmployeeListItem

@Composable
fun EmployeeRoot(
    viewModel: EmployeeViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    EmployeeScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun EmployeeScreen(
    state: EmployeeState,
    onAction: (EmployeeAction) -> Unit,
) {
//    val toppAppBarState = rememberTopAppBarState()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
//        state = toppAppBarState
//    )
//    val items = (1..100).toList()
    val users = listOf("User1", "User2", "User3", "User4", "User5", "User6", "User7", "User8", "User9", "User10")

    GradientBackground {
        Box(modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(vertical = 32.dp),

        ) {
            if (!state.isEmployeeDialogVisible) {
                Column(modifier = Modifier
                    .fillMaxSize()
                )
                {
                    LazyColumn (
                        modifier = Modifier
                            .weight(0.9f),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(users) {user ->
                            EmployeeListItem(modifier = Modifier.fillMaxWidth())
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.1f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        StarHelperActionButton(
                            text = "Add Employee",
                            isLoading = false,
                            onClick = {
                                onAction(EmployeeAction.onAddEmployeeDialogClick)
                            }
                        )
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp)),
                        color = MaterialTheme.colorScheme.surface,
                        tonalElevation = 6.dp
                    ) {
                        AddEmployeeDialog(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            state = state,
                            onAction = onAction
                        )
                    }

                }
            }

        }
    }


}

@Preview
@Composable
private fun Preview() {
    StarHelperTheme {
        EmployeeScreen(
            state = EmployeeState(),
            onAction = {}
        )
    }
}