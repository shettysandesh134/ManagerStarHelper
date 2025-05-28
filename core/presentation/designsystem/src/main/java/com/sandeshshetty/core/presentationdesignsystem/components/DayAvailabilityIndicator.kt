package com.sandeshshetty.core.presentationdesignsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme

/**
 * @author sandeshshetty
 * Created 5/22/25 at {TIME}
 */

@Composable
fun DayAvailabilityIndicator(
    modifier: Modifier = Modifier,
    dayTitle: String,
    enabled: Boolean = false,
    onClick: () -> Unit,
    isAvailable: Boolean,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .clickable(enabled = enabled, onClick = onClick)
            .background(
                if (isAvailable) {
                    Color.Green
                } else {
                    Color.Red
                }
            )
            .border(
                width = 0.5.dp,
                color = Color.White,
                shape = RoundedCornerShape(5.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center)
                .align(Alignment.Center),
            text = dayTitle,
            color = Color.Black,
            maxLines = 1,
            softWrap = false,
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
private fun DayAvailabilityIndicatorPreview() {
    StarHelperTheme {
        DayAvailabilityIndicator(
            dayTitle = "Mon",
            isAvailable = true,
            enabled = false,
            onClick = {}
        )
    }
}