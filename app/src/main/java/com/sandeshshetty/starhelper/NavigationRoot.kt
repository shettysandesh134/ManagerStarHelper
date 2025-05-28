package com.sandeshshetty.starhelper

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.sandeshshetty.auth.presentation.intro.IntroScreenRoot
import com.sandeshshetty.auth.presentation.login.LoginScreenRoot
import com.sandeshshetty.auth.presentation.register.RegisterScreenRoot
import com.sandeshshetty.core.presentationdesignsystem.components.Routes
import com.sandeshshetty.core.presentationdesignsystem.LogoIcon
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperBottomBar
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperScaffold
import com.sandeshshetty.core.presentationdesignsystem.components.StarHelperToolbar
import com.sandeshshetty.home.presentation.R
import com.sandeshshetty.home.presentation.dashboard.DashboardRoot
import com.sandeshshetty.home.presentation.employee.EmployeeRoot
import com.sandeshshetty.home.presentation.employee.EmployeeScreen

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean = false
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Routes.Dashboard.route else Routes.Auth.route
    ) {
        authGraph(navController)
        composable(Routes.Dashboard.route) {
            DashboardRoot(navController)
        }
//        dashboardGraph(navController,currentDestination)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = Routes.Intro.route,
        route = Routes.Auth.route
    ) {
        composable(Routes.Intro.route) {
            IntroScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(Routes.Register.route)
                }
            )
        }

        composable(Routes.Register.route) {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Register.route) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(Routes.Login.route)
                }
            )
        }

        composable(Routes.Login.route){
            LoginScreenRoot(
                onSignUpClick = {
                    navController.navigate(Routes.Register.route) {
                        popUpTo(Routes.Login.route) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onLoginSuccess = {
                    navController.navigate(Routes.Dashboard.route)
                }
            )
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardRoot(navController: NavHostController) {
    val bottomNavController = rememberNavController()
    val currentRoute = bottomNavController.currentBackStackEntryAsState().value?.destination?.route
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    val items = listOf(Routes.Home, Routes.Employee, Routes.Sale)

    StarHelperScaffold(
        topAppBar = {
            StarHelperToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.dashboard),
                scrollBehavior = scrollBehavior,
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        bottomAppBar = {
            StarHelperBottomBar(currentDestination = currentRoute) { screen ->
                bottomNavController.navigate(screen.route) {
                    popUpTo(bottomNavController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.Home.route) {
                DashboardRoot()
            }
            composable(Routes.Employee.route) {
                EmployeeRoot()
            }
            composable(Routes.Sale.route) {
                Text(text = "Sale Screen")
            }

        }
    }

}

