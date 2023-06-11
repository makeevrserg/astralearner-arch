@file:Suppress("UnusedPrivateMember")

plugins {
    id("mpp-library-convention")
}
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Settings
                implementation(libs.mppsettings)
                // MobileX
                implementation(libs.mobileX.serviceLocator)
                implementation(libs.mobileX.core.ktx)
                // Decompose
                implementation(libs.decompose.core)
                // Moko
                implementation(libs.moko.mvvm.core)
                implementation(libs.moko.resources.core)
            }
        }
    }
}
android {
    apply(plugin = "kotlin-parcelize")
    namespace = "${libs.versions.project.group.get()}.core"
}
