package com.makeevrserg.astralearner.di

import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.Lateinit
import com.makeevrserg.mobile.di.Module
import com.makeevrserg.mobile.di.Single
import com.makeevrserg.mobilex.core.platform.KotlinDispatchers
import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineScope

interface RootModule : Module {
    val platformConfiguration: Lateinit<PlatformConfiguration>
    val settings: Single<Settings>
    val dispatchers: Single<KotlinDispatchers>
    val mainScope: Single<CoroutineScope>
}
