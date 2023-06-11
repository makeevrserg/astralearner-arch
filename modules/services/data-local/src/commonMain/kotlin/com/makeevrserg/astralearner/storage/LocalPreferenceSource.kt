package com.makeevrserg.astralearner.storage

import com.makeevrserg.mobilex.core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

/**
 * This [LocalPreferenceSource] contains local preference data
 */
interface LocalPreferenceSource {

    /**
     * Is app was launched before
     */
    val isInitialLaunch: FlowStorageValue<Boolean>

    companion object {
        operator fun invoke(
            settings: Settings
        ): LocalPreferenceSource = LocalPreferenceSourceImpl(
            settings = settings
        )
    }
}
