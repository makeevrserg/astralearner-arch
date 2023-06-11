@file:Suppress("UnusedPrivateMember")

import com.makeevrserg.astralearner.AstraApk.APPLICATION_ID

plugins {
    id("org.jetbrains.compose")
    id("mpp-compose-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Compose MPP
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.runtime)
                implementation(compose.material)
                // MobileX
                implementation(libs.mobileX.core.ktx)
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.paging)
                // Moko
                implementation(libs.moko.resources.core)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)
                // Local
                implementation(project(":modules:features:splash"))
                implementation(project(":modules:services:resources"))
                implementation(project(":modules:services:data-local"))
                implementation(project(":modules:services:core-ui"))
                implementation(project(":modules:features:root"))
            }
        }
    }
}
android {
    namespace = APPLICATION_ID + ".features.ui.splash"
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compilerExtensionVersion.get()
    }
    buildFeatures {
        compose = true
    }
}
