package com.sandeshshetty.home.presentation.employee.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.sandeshshetty.core.domain.employee.EmploymentType
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.DayAvailabilityIndicator
import com.sandeshshetty.core.presentationdesignsystem.components.GradientBackground
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperActionButton
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperTextField
import com.sandeshshetty.home.presentation.R
import com.sandeshshetty.home.presentation.employee.EmployeeAction
import com.sandeshshetty.home.presentation.employee.EmployeeState


/**
 * @author sandeshshetty
 * Created 5/22/25 at {TIME}
 */

@Composable
fun AddEmployeeDialog(
    modifier: Modifier = Modifier,
    state: EmployeeState,
    onAction: (EmployeeAction) -> Unit,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.weight(2f),
                    text = "Add Employee",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {
                    onAction(EmployeeAction.onDismissAddEmployeeDialog)
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null
                    )
                }
            }

            Spacer(Modifier.height(4.dp))
            StarHelperTextField(
                state = state.fname,
                hint = stringResource(R.string.first_name),
                title = stringResource(R.string.first_name),
                modifier = Modifier.fillMaxWidth(),
                startIcon = null,
                endIcon = null
            )
            Spacer(Modifier.height(4.dp))
            StarHelperTextField(
                state = state.fname,
                hint = stringResource(R.string.last_name),
                title = stringResource(R.string.last_name),
                modifier = Modifier.fillMaxWidth(),
                startIcon = null,
                endIcon = null
            )
            Spacer(Modifier.height(4.dp))
            StarHelperTextField(
                state = state.fname,
                hint = stringResource(R.string.phoneNumber_hint),
                title = stringResource(R.string.phone_number),
                modifier = Modifier.fillMaxWidth(),
                startIcon = null,
                endIcon = null
            )
            Spacer(Modifier.height(4.dp))
            EmploymentTypeSelector(
                title = "Select Employment Type",
                selectedType = state.employmentType,
                modifier = Modifier.fillMaxWidth(),
                onTypeSelected = {
                    onAction(EmployeeAction.OnEmploymentTypeSelection(it))
                }
            )
            Spacer(Modifier.height(4.dp))
            when (state.employmentType) {
                is EmploymentType.Casual -> {
                    StarHelperTextField(
                        state = state.hourlyRate,
                        hint = state.employmentType.hourlyRate.toString(),
                        title = stringResource(R.string.hourly_rate),
                        modifier = Modifier.fillMaxWidth(),
                        additionalInfo = stringResource(R.string.per_hour_rate_employee),
                        startIcon = null,
                        endIcon = null
                    )
                }

                is EmploymentType.FullTime -> {
                    StarHelperTextField(
                        state = state.hourlyRate,
                        hint = state.employmentType.dailyRate.toString(),
                        title = stringResource(R.string.daily_rate),
                        additionalInfo = stringResource(R.string.per_day_rate_employee),
                        modifier = Modifier.fillMaxWidth(),
                        startIcon = null,
                        endIcon = null
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            StarHelperTextField(
                                state = state.startTime,
                                hint = state.employmentType.startTime,
                                title = stringResource(R.string.shift_start_time_full_time_employee),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp),
                                startIcon = null,
                                endIcon = null
                            )
                        }
                        Row(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            StarHelperTextField(
                                state = state.startTime,
                                hint = state.employmentType.endTime,
                                title = stringResource(R.string.shift_end_time_full_time_employee),
                                modifier = Modifier.fillMaxWidth(),
                                startIcon = null,
                                endIcon = null
                            )
                        }
                    }
                }

            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                state.dayAvailable.forEach { day ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        DayAvailabilityIndicator(
                            dayTitle = day.dayOfWeekString,
                            enabled = true,
                            isAvailable = day.isAvailable,
                            onClick = {
                                onAction(EmployeeAction.onEmployeeDayAvailabilityChange(day.dayOfWeek))
                            }
                        )
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            StarHelperActionButton(
                text = "Add Employee",
                isLoading = state.isAddingEmployee,
                modifier = Modifier.fillMaxWidth(),
                enabled = state.canAddEmployee,
                onClick = {
                    onAction(EmployeeAction.onAddEmployeeClick)
                }
            )
        }

    }
}

@Composable
fun EmploymentTypeSelector(
    modifier: Modifier = Modifier,
    title: String,
    selectedType: EmploymentType,
    onTypeSelected: (EmploymentType) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        EmploymentType.employmentOptions.forEach { type ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedType::class == type::class,
                    onClick = {
                        onTypeSelected(type)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = type::class.simpleName ?: "",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}


//@Preview
//@Composable
//private fun EmploymentTypeSelectorPreview() {
//    StarHelperTheme {
//        EmploymentTypeSelector(
//            title = "Select Employment Type",
//            selectedType = EmploymentType.Casual(10.0),
//            onTypeSelected = {}
//        )
//    }
//}

@Preview
@Composable
private fun AddEmployeeDialogPreview() {
    StarHelperTheme {
            AddEmployeeDialog(
                modifier = Modifier.fillMaxSize()
                    .padding(8.dp),
                state = EmployeeState(),
                onAction = {}
            )
    }
}
