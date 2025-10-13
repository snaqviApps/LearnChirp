
import learn.plcoding.chirp.convention.configureAndroidTarget
import learn.plcoding.chirp.convention.configureIosTargets
import learn.plcoding.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpApplicationConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("learn.plcoding.convention.android.application.compose")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            configureAndroidTarget()
            configureIosTargets()

            dependencies {
                "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
            }
        }
    }
}