package com.makeevrserg.astralearner.features.logic.splash.data

import com.makeevrserg.astralearner.storage.LocalPreferenceSource
import com.makeevrserg.mobilex.core.storage.FlowStorageValue

interface SplashComponentRepository {
    /**
     * Is app was launched before
     */
    val isInitialLaunch: FlowStorageValue<Boolean>

    /**
     * Default implementation for this interface from [LocalPreferenceSource]
     */
    class Default(localPreferenceSource: LocalPreferenceSource) : SplashComponentRepository {
        override val isInitialLaunch: FlowStorageValue<Boolean> = localPreferenceSource.isInitialLaunch
    }
}
