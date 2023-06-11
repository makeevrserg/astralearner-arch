package com.makeevrserg.astralearner.navigation

import com.makeevrserg.astralearner.features.logic.splash.SplashComponent

sealed interface RootConfiguration {
    class Splash(
        val splashComponent: SplashComponent
    ) : RootConfiguration
}
