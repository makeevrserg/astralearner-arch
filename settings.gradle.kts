pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "AstraLearner"

include(":app")
include(":desktop")
include(":modules:features:root")

// Splash
include(":modules:features:splash")
include(":modules:features:ui:splash")

// Services -----------------------
include(":modules:services:core-ui")
include(":modules:services:data-local")
include(":modules:services:resources")
include(":modules:services:core")
