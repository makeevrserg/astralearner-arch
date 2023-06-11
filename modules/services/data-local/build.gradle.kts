@file:Suppress("UnusedPrivateMember")

plugins {
    id("mpp-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // MobileX
                implementation(libs.mobileX.core.ktx)
                // Settings
                implementation(libs.mppsettings)
            }
        }
    }
}

android { namespace = "${libs.versions.project.group.get()}.data.local" }
