package com.sandeshshetty.home.presentation.employee.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.DayAvailabilityIndicator

/**
 * @author sandeshshetty
 * Created 5/22/25 at {TIME}
 */

@Composable
fun EmployeeListItem(
    modifier: Modifier = Modifier
) {
    Box {
        Row(
            modifier = modifier
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.8f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Sandesh Shetty",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Full Time",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
//                    DayAvailabilityIndicator(
//                        dayTitle = "Mon",
//                        isAvailable = true
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Tue",
//                        isAvailable = false
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Mon",
//                        isAvailable = true
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Tue",
//                        isAvailable = false
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Mon",
//                        isAvailable = true
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Tue",
//                        isAvailable = false
//                    )
//                    DayAvailabilityIndicator(
//                        dayTitle = "Tue",
//                        isAvailable = false
//                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(0.2f)
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun EmployeeListItemPreview() {
    StarHelperTheme {
        EmployeeListItem()
    }
}