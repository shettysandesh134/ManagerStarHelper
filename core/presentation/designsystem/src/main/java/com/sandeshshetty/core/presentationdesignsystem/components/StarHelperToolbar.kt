package com.sandeshshetty.core.presentationdesignsystem.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sandeshshetty.core.presentationdesignsystem.ArrowLeftIcon
import com.sandeshshetty.core.presentationdesignsystem.LogoIcon
import com.sandeshshetty.core.presentationdesignsystem.Poppins
import com.sandeshshetty.core.presentationdesignsystem.R
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme

/**
 * @author sandeshshetty
 * Created 5/14/25 at {TIME}
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarHelperToolbar(
    modifier: Modifier = Modifier,
    showBackButton: Boolean,
    title: String,
    onBackClick: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    startContent: (@Composable () -> Unit)? = null
) {
    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                startContent?.invoke()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = Poppins
                )
            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            if(showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ArrowLeftIcon,
                        contentDescription = stringResource(id = R.string.go_back),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun StarHelperToolbarPreview() {
    StarHelperTheme {
        StarHelperToolbar(
            showBackButton = false,
            title = "Title",
            onBackClick = {},
            startContent = {
                Icon(imageVector = LogoIcon, contentDescription = null)
            }
        )
    }
}