package com.makeevrserg.astralearner.desktop

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.astralearner.di.impl.root.RootModuleImpl
import com.makeevrserg.astralearner.di.impl.root.ServicesModuleImpl
import com.makeevrserg.astralearner.features.ui.splash.ComposeApplication
import com.makeevrserg.astralearner.navigation.DefaultRootComponent
import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.getValue

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    val rootModule by RootModuleImpl
    val servicesModule by ServicesModuleImpl
    rootModule.platformConfiguration.initialize(PlatformConfiguration())

    val lifecycle = LifecycleRegistry()
    val rootComponentContext = DefaultComponentContext(lifecycle)
    val root = runOnUiThread {
        DefaultRootComponent(
            componentContext = rootComponentContext,
            rootModule = rootModule,
            servicesModule = servicesModule
        )
    }

    val windowState = WindowState(
        placement = WindowPlacement.Floating,
        size = DpSize(600.dp, 800.dp)
    )

    singleWindowApplication(
        state = windowState,
        title = "AstraLearner",
    ) {
        LifecycleController(lifecycle, windowState)
        ComposeApplication(
            component = root,
            preferencesDataSource = servicesModule.localPreferenceModule.provide()
        )
    }
}
