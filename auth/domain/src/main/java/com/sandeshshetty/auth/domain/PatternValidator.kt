package com.sandeshshetty.auth.domain

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */
interface PatternValidator {
    fun matches(value: String): Boolean
}