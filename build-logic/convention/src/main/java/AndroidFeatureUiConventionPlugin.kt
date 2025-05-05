import com.sandeshshetty.convention.addUiLayerDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * @author sandeshshetty
 * Created 5/5/25 at {TIME}
 */
class AndroidFeatureUiConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("starhelper.android.library.compose")
            }

            dependencies {
                addUiLayerDependencies(target)
            }
        }
    }
}