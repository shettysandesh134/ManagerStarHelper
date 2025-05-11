package com.sandeshshetty.auth.data

import android.util.Patterns
import com.sandeshshetty.auth.domain.PatternValidator

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */
class EmailPatternValidtor: PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}