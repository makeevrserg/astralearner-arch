package com.makeevrserg.astralearner.di.impl.features.splash

import com.makeevrserg.astralearner.di.RootModule
import com.makeevrserg.astralearner.di.ServicesModule
import com.makeevrserg.astralearner.features.logic.splash.data.SplashComponentRepository
import com.makeevrserg.astralearner.features.logic.splash.di.SplashComponentModule
import com.makeevrserg.mobile.di.Provider
import com.makeevrserg.mobile.di.getValue
import com.makeevrserg.mobilex.core.platform.KotlinDispatchers
import kotlinx.coroutines.CoroutineScope

class SplashComponentModuleImpl(
    rootModule: RootModule,
    servicesModule: ServicesModule
) : SplashComponentModule {

    override val scope: CoroutineScope by rootModule.mainScope
    override val dispatchers: KotlinDispatchers by rootModule.dispatchers
    override val repository: SplashComponentRepository = Provider {
        SplashComponentRepository.Default(servicesModule.localPreferenceModule.provide())
    }.provide()
}
