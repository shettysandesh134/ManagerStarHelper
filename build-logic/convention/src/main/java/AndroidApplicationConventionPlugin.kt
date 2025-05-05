import com.android.build.api.dsl.ApplicationExtension
import com.sandeshshetty.convention.ExtensionType
import com.sandeshshetty.convention.configureBuildTypes
import com.sandeshshetty.convention.configureKotlinAndroid
import com.sandeshshetty.convention.configureKotlinJvm
import com.sandeshshetty.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author sandeshshetty
 * Created 5/4/25 at {TIME}
 * This is created to make the build.gradle.kts level plugin so that it can be reused in other module
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            //This block is equivalent to "android{}" in build.gradle.kts
            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.findVersion("projectApplicationId").get().toString()
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()

                    versionCode = libs.findVersion("projectVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("projectVersionName").get().toString()
                }

                configureKotlinAndroid(this)
                configureBuildTypes(
                        commonExtension = this,
                extensionType = ExtensionType.APPLICATION
                )
            }

        }
    }
}