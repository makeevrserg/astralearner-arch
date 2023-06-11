package com.makeevrserg.astralearner.application

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.makeevrserg.astralearner.di.impl.root.RootModuleImpl
import com.makeevrserg.astralearner.platform.PlatformConfiguration
import com.makeevrserg.mobile.di.getValue

class App : Application() {
    private val rootModule by RootModuleImpl

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
        rootModule.platformConfiguration.initialize(PlatformConfiguration(applicationContext))
    }
}
