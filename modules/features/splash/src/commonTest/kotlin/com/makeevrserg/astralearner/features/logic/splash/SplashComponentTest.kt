package com.makeevrserg.astralearner.features.logic.splash

import app.cash.turbine.test
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.makeevrserg.astralearner.features.logic.splash.data.SplashComponentRepository
import com.makeevrserg.astralearner.features.logic.splash.di.SplashComponentModule
import com.makeevrserg.mobilex.core.platform.KDispatchers
import com.makeevrserg.mobilex.core.platform.KotlinDispatchers
import com.makeevrserg.mobilex.core.storage.DefaultFlowStorageValue
import com.makeevrserg.mobilex.core.storage.FlowStorageValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SplashComponentTest {
    private fun buildModule(isInitialLaunch: Boolean) = object : SplashComponentModule {
        override val scope: CoroutineScope = MainScope()
        override val dispatchers: KotlinDispatchers = KDispatchers
        override val repository: SplashComponentRepository = object : SplashComponentRepository {
            override val isInitialLaunch: FlowStorageValue<Boolean> = InMemoryStorageValue(isInitialLaunch)
        }
    }

    private val componentContext = DefaultComponentContext(LifecycleRegistry())

    @Test
    fun TEST_initial_launch_true(): Unit = runBlocking {
        val expectInitialLaunchValue = true
        val splashComponent = SplashComponentImpl(componentContext, buildModule(expectInitialLaunchValue))
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }

    @Test
    fun TEST_initial_launch_false(): Unit = runBlocking {
        val expectInitialLaunchValue = false
        val splashComponent = SplashComponentImpl(componentContext, buildModule(expectInitialLaunchValue))
        splashComponent.screenChannelFlow.test {
            val item = awaitItem()
            assertTrue(item is SplashComponent.Label.InitialLaunch)
            assertEquals(expectInitialLaunchValue, item.value)
        }
    }
}

@Deprecated("In MobileX 2.6.6")
private class InMemoryStorageValue<T>(
    default: T
) : FlowStorageValue<T> by DefaultFlowStorageValue<T>(
    default = default,
    loadSettingsValue = { default },
    saveSettingsValue = {}
)
