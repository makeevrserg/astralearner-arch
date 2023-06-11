@file:Suppress("UnusedPrivateMember")

import org.jetbrains.compose.desktop.application.dsl.TargetFormat


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}
java {
    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion
}
kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion
        }
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                // Compose
                implementation(compose.desktop.currentOs)
                // Decompose
                implementation(libs.decompose.core)
                implementation(libs.decompose.compose.jetbrains)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                // Coroutines
                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kotlin.coroutines.swing)
                // Local
                implementation(project(":modules:services:core"))
                implementation(project(":modules:services:data-local"))
                implementation(project(":modules:features:root"))
                implementation(project(":modules:features:splash"))
                implementation(project(":modules:features:ui:splash"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.makeevrserg.astralearner.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jvm"
            packageVersion = "1.0.0"
        }
    }
}
