package com.makeevrserg.astralearner.di.factories

import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.Factory
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
actual class SettingsFactory actual constructor(
    private val configuration: PlatformConfiguration
) : Factory<Settings> {
    override fun build(): Settings {
        return PreferencesSettings(configuration.preferences)
    }
}
