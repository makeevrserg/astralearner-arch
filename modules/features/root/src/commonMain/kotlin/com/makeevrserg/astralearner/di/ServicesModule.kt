package com.makeevrserg.astralearner.di

import com.makeevrserg.astralearner.storage.LocalPreferenceSource
import com.makeevrserg.mobile.di.Module
import com.makeevrserg.mobile.di.Provider

interface ServicesModule : Module {
    val localPreferenceModule: Provider<LocalPreferenceSource>
}
