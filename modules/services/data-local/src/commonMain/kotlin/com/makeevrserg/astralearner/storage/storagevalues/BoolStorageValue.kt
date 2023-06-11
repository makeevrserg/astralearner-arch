package com.makeevrserg.astralearner.storage.storagevalues

import com.makeevrserg.mobilex.core.storage.DefaultFlowStorageValue
import com.makeevrserg.mobilex.core.storage.FlowStorageValue
import com.russhwolf.settings.Settings

internal class BoolStorageValue(
    settings: Settings,
    key: String,
    default: Boolean,
) : FlowStorageValue<Boolean> by DefaultFlowStorageValue(
    default = default,
    loadSettingsValue = {
        settings.getBoolean(key, default)
    },
    saveSettingsValue = {
        settings.putBoolean(key, it)
    }
)
