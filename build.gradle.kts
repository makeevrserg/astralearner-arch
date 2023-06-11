// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.dokka.gradle.DokkaTask

buildscript {
    dependencies {
        classpath(libs.moko.resources.generator)
        classpath(libs.moko.network.generator)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.gradle.buildconfig) apply false
    alias(libs.plugins.gradle.ksp) apply false
    alias(libs.plugins.gradle.dokka) apply true
    alias(libs.plugins.gradle.shadow) apply true
    id("detekt-convention")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        perPackageOption {
            reportUndocumented.set(false)
        }
    }
}
