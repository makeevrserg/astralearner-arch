package com.makeevrserg.astralearner.di.factories

import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.Factory
import com.russhwolf.settings.Settings
expect class SettingsFactory(
    configuration: PlatformConfiguration
) : Factory<Settings>
