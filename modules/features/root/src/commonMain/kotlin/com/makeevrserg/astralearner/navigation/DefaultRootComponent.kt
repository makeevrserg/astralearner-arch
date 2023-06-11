package com.makeevrserg.astralearner.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.makeevrserg.astralearner.di.RootModule
import com.makeevrserg.astralearner.di.ServicesModule
import com.makeevrserg.astralearner.di.impl.features.splash.SplashComponentModuleImpl
import com.makeevrserg.astralearner.features.logic.splash.SplashComponentImpl

class DefaultRootComponent(
    componentContext: ComponentContext,
    rootModule: RootModule,
    servicesModule: ServicesModule
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<RootScreen>()

    override val childStack: Value<ChildStack<RootScreen, RootConfiguration>> = childStack(
        source = navigation,
        initialConfiguration = RootScreen.Splash,
        handleBackButton = true,
        childFactory = { config, context ->

            when (config) {

                RootScreen.Splash -> RootConfiguration.Splash(
                    splashComponent = SplashComponentImpl(
                        context = context,
                        module = SplashComponentModuleImpl(
                            rootModule = rootModule,
                            servicesModule = servicesModule
                        )
                    )
                )
            }
        }
    )

    override fun push(screen: RootScreen) {
        navigation.push(screen)
    }

    override fun replaceCurrent(screen: RootScreen) {
        navigation.replaceCurrent(screen)
    }

    override fun replaceAll(screen: RootScreen) {
        navigation.replaceAll(screen)
    }

    override fun pop() {
        navigation.pop()
    }
}
