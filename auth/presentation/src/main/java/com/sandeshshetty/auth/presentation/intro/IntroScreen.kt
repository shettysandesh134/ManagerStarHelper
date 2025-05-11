package com.sandeshshetty.auth.presentation.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sandeshshetty.auth.presentation.R
import com.sandeshshetty.core.presentationdesignsystem.LogoIcon
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.GradientBackground
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperActionButton
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperOutlinedActionButton
import org.koin.androidx.compose.koinViewModel

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

@Composable
fun IntroScreenRoot(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    IntroScreen(
        onAction = { introAction ->
            when (introAction) {
                IntroAction.OnSignInClick -> onSignInClick()
                IntroAction.OnSignUpClick -> onSignUpClick()
            }
        }
    )

}

@Composable
private fun IntroScreen(
    onAction: (IntroAction) -> Unit
) {
    GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            RuniqueLogoVertical()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 48.dp)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_to_star_helper),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(id = R.string.star_helper_description),
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(32.dp))
            StarHelperOutlinedActionButton(
                text = stringResource(id = R.string.sign_in),
                isLoading = false,
                onClick = {
                    onAction(IntroAction.OnSignInClick)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            StarHelperActionButton(
                text = stringResource(id = R.string.sign_up),
                isLoading = false,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onAction(IntroAction.OnSignUpClick)
                }
            )
        }
    }
}

@Composable
private fun RuniqueLogoVertical(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = LogoIcon,
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = stringResource(id = R.string.star),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    StarHelperTheme {
        IntroScreen(
            onAction = {}
        )
    }
}