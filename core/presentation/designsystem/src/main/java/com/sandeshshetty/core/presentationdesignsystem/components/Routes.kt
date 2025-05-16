package com.sandeshshetty.core.presentationdesignsystem.components



/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

sealed class Routes(val route: String) {
    object Auth: Routes("auth")
    object Intro: Routes("intro")
    object Login: Routes("login")
    object Register: Routes("register")

    object Dashboard: Routes("dashboard")

    object Home: Routes("dashboard/home")
    object Employee: Routes("dashboard/employee")
    object Sale: Routes("dashboard/sale")
}