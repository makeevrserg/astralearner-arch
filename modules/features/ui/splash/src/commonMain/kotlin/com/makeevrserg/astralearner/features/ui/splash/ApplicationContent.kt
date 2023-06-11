package com.makeevrserg.astralearner.features.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.makeevrserg.astralearner.di.impl.root.RootModuleImpl
import com.makeevrserg.astralearner.di.impl.root.ServicesModuleImpl
import com.makeevrserg.astralearner.navigation.DefaultRootComponent
import com.makeevrserg.astralearner.navigation.RootConfiguration
import com.makeevrserg.mobile.di.getValue

@Composable
fun ApplicationContent(component: DefaultRootComponent) {
    val rootModule by RootModuleImpl
    val servicesModule by ServicesModuleImpl

    val childStack by component.childStack.subscribeAsState()
    Children(
        stack = childStack,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnimation(slide())
    ) { configuration ->

        when (val screen = configuration.instance) {
            is RootConfiguration.Splash -> SplashScreenComponent(
                rootComponent = component,
                splashComponent = screen.splashComponent
            )
        }
    }
}
