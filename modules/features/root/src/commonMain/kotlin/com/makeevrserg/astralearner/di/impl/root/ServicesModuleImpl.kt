package com.makeevrserg.astralearner.di.impl.root

import com.makeevrserg.astralearner.di.ServicesModule
import com.makeevrserg.astralearner.storage.LocalPreferenceSource
import com.makeevrserg.mobile.di.Provider
import com.makeevrserg.mobile.di.getValue

object ServicesModuleImpl : ServicesModule {
    private val rootModule by RootModuleImpl

    override val localPreferenceModule = Provider {
        val settings by rootModule.settings
        LocalPreferenceSource(settings)
    }
}
