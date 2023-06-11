package com.makeevrserg.astralearner.storage

import com.makeevrserg.astralearner.storage.storagevalues.BoolStorageValue
import com.makeevrserg.mobilex.core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

internal class LocalPreferenceSourceImpl(settings: Settings) : LocalPreferenceSource {

    override val isInitialLaunch: FlowStorageValue<Boolean> = BoolStorageValue(
        settings = settings,
        key = "isInitialLaunch",
        default = true
    )
}
