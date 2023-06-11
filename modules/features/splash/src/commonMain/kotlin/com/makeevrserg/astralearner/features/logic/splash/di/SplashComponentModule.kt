package com.makeevrserg.astralearner.features.logic.splash.di

import com.makeevrserg.astralearner.features.logic.splash.data.SplashComponentRepository
import com.makeevrserg.mobile.di.Module
import com.makeevrserg.mobilex.core.platform.KotlinDispatchers
import kotlinx.coroutines.CoroutineScope

interface SplashComponentModule : Module {
    val scope: CoroutineScope
    val dispatchers: KotlinDispatchers
    val repository: SplashComponentRepository
}
