package com.sandeshshetty.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * @author sandeshshetty
 * Created 5/4/25 at {TIME}
 */

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

       dependencies {
           val bom = libs.findLibrary("androidx.compose.bom").get()
           "implementation"(platform(bom))
           "androidTestImplementation"(platform(bom))
           "debugImplementation"(libs.findLibrary("androidx.compose.ui.tooling.preview").get())
       }
    }
}