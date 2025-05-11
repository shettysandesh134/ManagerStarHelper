package com.sandeshshetty.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sandeshshetty.auth.presentation.R
import com.sandeshshetty.core.presentation.ui.ObserveAsEvents
import com.sandeshshetty.core.presentationdesignsystem.EmailIcon
import com.sandeshshetty.core.presentationdesignsystem.Poppins
import com.sandeshshetty.core.presentationdesignsystem.StarHelperTheme
import com.sandeshshetty.core.presentationdesignsystem.components.GradientBackground
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperActionButton
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperPasswordTextField
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperTextField
import org.koin.androidx.compose.koinViewModel

/**
 * @author sandeshshetty
 * Created 5/10/25 at {TIME}
 */

@Composable
fun LoginScreenRoot(
    onSignUpClick: () -> Unit,
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    ObserveAsEvents(viewModel.events) { events ->
        when (events) {
            is LoginEvent.Error -> {
                keyboardController?.hide()
                Toast.makeText(context, events.error.asString(context), Toast.LENGTH_SHORT).show()
            }
            LoginEvent.LoginSuccess -> {
                keyboardController?.hide()
                Toast.makeText(context, R.string.youre_logged_in, Toast.LENGTH_SHORT).show()
                onLoginSuccess()
            }
        }
    }

    LoginScreen(
        state = viewModel.state,
        onAction = { action ->
            when (action) {
                is LoginAction.OnRegisterClick -> onSignUpClick()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )

}

@Composable
private fun LoginScreen(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {
    GradientBackground {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.hi_there),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(id = R.string.starhelper_welcome_text),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(48.dp))

            StarHelperTextField(
                state = state.email,
                startIcon = EmailIcon,
                endIcon = null,
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = R.string.example_email),
                title = stringResource(id = R.string.email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            StarHelperPasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(LoginAction.OnTogglePasswordVisibilityClick)
                },
                hint = stringResource(id = R.string.password),
                title = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            StarHelperActionButton(
                text = stringResource(id = R.string.login),
                isLoading = state.isLoggingIn,
                enabled = state.canLogin && !state.isLoggingIn,
                onClick = {
                    onAction(LoginAction.OnLoginClick)
                },
            )

            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    append(stringResource(id = R.string.dont_have_an_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(id = R.string.sign_up)
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.primary,
                            fontFamily = Poppins
                        )
                    ) {
                        append(stringResource(id = R.string.sign_up))
                    }
                }
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .navigationBarsPadding()
                    .weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                ClickableText(
                    text = annotatedString,
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(
                            tag = "clickable_text",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            onAction(LoginAction.OnRegisterClick)
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    StarHelperTheme {
        LoginScreen(
            state = LoginState(),
            onAction = {}
        )
    }
}