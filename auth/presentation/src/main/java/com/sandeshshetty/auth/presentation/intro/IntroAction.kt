package com.sandeshshetty.auth.presentation.intro

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */

sealed interface IntroAction {
    data object OnSignInClick: IntroAction
    data object OnSignUpClick: IntroAction
}