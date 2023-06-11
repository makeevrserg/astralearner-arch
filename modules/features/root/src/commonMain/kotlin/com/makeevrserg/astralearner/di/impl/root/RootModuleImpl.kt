package com.makeevrserg.astralearner.di.impl.root

import com.makeevrserg.astralearner.di.RootModule
import com.makeevrserg.astralearner.di.factories.SettingsFactory
import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.Lateinit
import com.makeevrserg.mobile.di.Single
import com.makeevrserg.mobile.di.getValue
import com.makeevrserg.mobilex.core.platform.KDispatchers
import com.makeevrserg.mobilex.core.platform.KotlinDispatchers
import kotlinx.coroutines.MainScope

object RootModuleImpl : RootModule {
    override val platformConfiguration = Lateinit<PlatformConfiguration>()

    override val settings = Single {
        val configuration by platformConfiguration
        SettingsFactory(configuration).build()
    }
    override val dispatchers = Single<KotlinDispatchers> {
        KDispatchers
    }
    override val mainScope = Single {
        MainScope()
    }
}
