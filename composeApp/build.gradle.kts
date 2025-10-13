
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.convention.cmp.application)
    alias(libs.plugins.compose.hot.reload)
}

version = "1.0.0"

kotlin {
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(projects.core.data)
            implementation(projects.core.domain)
            implementation(projects.core.designsystem)
            implementation(projects.core.presentation)

//            implementation(projects.feature.auth.domain)
//            implementation(projects.feature.auth.presentation)
//            -------> above two dependencies cause this error:'.....D8: Type learn.plcoding.auth.presentation.Platform_androidKt is defined multiple times:'

            implementation(projects.feature.chat.data)
            implementation(projects.feature.chat.database)
            implementation(projects.feature.chat.domain)
            implementation(projects.feature.chat.presentation)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
//            implementation(libs.androidx.lifecycle.viewmodel.compose)
            implementation(libs.jetbrains.compose.viewmodel)

            implementation(libs.jetbrains.lifecycle.compose)
        }
    }
}
