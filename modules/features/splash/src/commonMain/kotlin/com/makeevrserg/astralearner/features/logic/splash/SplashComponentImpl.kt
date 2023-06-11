package com.makeevrserg.astralearner.features.logic.splash

import com.arkivanov.decompose.ComponentContext
import com.makeevrserg.astralearner.features.logic.splash.di.SplashComponentModule
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class SplashComponentImpl(
    context: ComponentContext,
    module: SplashComponentModule
) : SplashComponent,
    SplashComponentModule by module,
    ComponentContext by context {
    private val _screenChannel = Channel<SplashComponent.Label>()
    override val screenChannelFlow = _screenChannel.consumeAsFlow()

    init {
        scope.launch(dispatchers.IO) {
            val isFirstLaunch = repository.isInitialLaunch.loadValue()
            _screenChannel.send(SplashComponent.Label.InitialLaunch(isFirstLaunch))
        }
    }
}
