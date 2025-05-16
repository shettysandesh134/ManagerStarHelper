package com.sandeshshetty.core.presentationdesignsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @author sandeshshetty
 * Created 5/14/25 at {TIME}
 */

@Composable
fun StarHelperScaffold(
    withGradient: Boolean = true,
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    bottomAppBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold (
        topBar = topAppBar,
        bottomBar = bottomAppBar,
        modifier = modifier
    ) { padding ->
        if(withGradient) {
            GradientBackground {
                content(padding)
            }
        } else {
            content(padding)
        }
    }
}