
import com.makeevrserg.astralearner.AstraApk.ACTIVITY_AD_UNIT_ID
import com.makeevrserg.astralearner.AstraApk.APPLICATION_ID
import com.makeevrserg.astralearner.AstraApk.BANNER_AD_UNIT_ID
import com.makeevrserg.astralearner.AstraApk.VERSION_CODE
import com.makeevrserg.astralearner.AstraApk.VERSION_STRING
import com.makeevrserg.astralearner.AstraApk.WEB_CLIENT_ID

plugins {
    kotlin("plugin.serialization")
    id("android-app-convention")
    id("signing-convention")
}

android {
    apply(plugin = "kotlin-parcelize")
    packagingOptions {
        resources {
            pickFirsts += listOf(
                "META-INF/DEPENDENCIES.txt",
                "META-INF/LICENSE.txt",
                "META-INF/NOTICE.txt",
                "META-INF/NOTICE",
                "META-INF/LICENSE",
                "META-INF/DEPENDENCIES",
                "META-INF/notice.txt",
                "META-INF/license.txt",
                "META-INF/dependencies.txt",
                "META-INF/LGPL2.1"
            )
        }
    }
    defaultConfig {
        applicationId = APPLICATION_ID
        versionCode = VERSION_CODE
        versionName = VERSION_STRING

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas".toString(),
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
        }
        buildConfigField("String", "WEB_CLIENT_ID", WEB_CLIENT_ID)
        buildConfigField("String", "BANNER_AD_UNIT_ID", BANNER_AD_UNIT_ID)
        buildConfigField("String", "ACTIVITY_AD_UNIT_ID", ACTIVITY_AD_UNIT_ID)
        buildConfigField("Boolean", "HAS_GOOGLE_SERVICES", file("google-services.json").exists().toString())
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlin.compilerExtensionVersion.get()
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Coroutines
    implementation(libs.kotlin.coroutines.core)
    implementation(libs.kotlin.coroutines.android)
    // Yandex
    implementation(libs.yandex.ads)
    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material:material")
    implementation("com.google.android.material:material:1.5.0")
    // FireBase
    implementation(platform(libs.google.firebase.bom))
    implementation(libs.google.auth)
    implementation(libs.google.firebase.analytics)
    implementation(libs.kotlin.coroutines.playServices)
    implementation(libs.google.firebase.crsahlytics)
    debugImplementation(libs.leakcanary)
    // MobileX
    implementation(libs.mobileX.core.ktx)
    implementation(libs.mobileX.serviceLocator)
    // Decompose
    implementation(libs.decompose.core)
    implementation(libs.decompose.compose.jetpack)
    implementation(libs.decompose.android)
    // Local
    implementation(project(":modules:services:core"))
    implementation(project(":modules:services:resources"))
    implementation(project(":modules:features:root"))
    implementation(project(":modules:features:splash"))
    implementation(project(":modules:features:ui:splash"))
    implementation(project(":modules:services:data-local"))
}
