package com.sandeshshetty.core.presentationdesignsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

val DarkColorScheme = darkColorScheme(
    primary = RuniqueGreen,
    background = RuniqueBlack,
    surface = RuniqueDarkGray,
    secondary = RuniqueWhite,
    tertiary = RuniqueWhite,
    primaryContainer = RuniqueGreen30,
    onPrimary = RuniqueBlack,
    onBackground = RuniqueWhite,
    onSurface = RuniqueWhite,
    onSurfaceVariant = RuniqueGray,
    error = RuniqueDarkRed,
    errorContainer = RuniqueDarkRed5
)

@Composable
fun StarHelperTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
    }

    MaterialTheme (
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

}