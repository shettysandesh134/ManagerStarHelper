package com.sandeshshetty.starhelper

import kotlinx.serialization.Serializable

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

sealed interface Routes {

    @Serializable
    data object Intro: Routes

    @Serializable
    data object Auth: Routes

    @Serializable
    data object Register: Routes

    @Serializable
    data object Login: Routes

    @Serializable
    data object DashBoard: Routes

    @Serializable
    data object Home: Routes

    @Serializable
    data object Profile: Routes

    @Serializable
    data object Sale: Routes
}