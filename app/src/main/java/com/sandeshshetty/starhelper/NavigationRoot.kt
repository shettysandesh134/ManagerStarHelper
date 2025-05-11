package com.sandeshshetty.starhelper

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.sandeshshetty.auth.presentation.intro.IntroScreenRoot
import com.sandeshshetty.auth.presentation.login.LoginScreenRoot
import com.sandeshshetty.auth.presentation.register.RegisterScreenRoot

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Auth
    ) {
        authGraph(navController)
//        dashboardGraph(navController)
    }
}

private fun NavGraphBuilder.dashboardGraph(navController: NavHostController) {
    navigation<Routes.DashBoard>(
        startDestination = Routes.Home
    ) {

    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Routes.Auth>(
        startDestination = Routes.Intro
    ) {
        composable<Routes.Intro> {
            IntroScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login)
                },
                onSignUpClick = {
                    navController.navigate(Routes.Register)
                }
            )
        }

        composable<Routes.Register> {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login) {
                        popUpTo(Routes.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(Routes.Login)
                }
            )
        }

        composable<Routes.Login>{
            LoginScreenRoot(
                onSignUpClick = {
                    navController.navigate(Routes.Register) {
                        popUpTo(Routes.Login) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onLoginSuccess = {
                    navController.navigate(Routes.Auth)
                }
            )
        }
    }
}

