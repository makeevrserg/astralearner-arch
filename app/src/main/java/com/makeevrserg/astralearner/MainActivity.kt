package com.makeevrserg.astralearner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.arkivanov.decompose.defaultComponentContext
import com.makeevrserg.astralearner.di.impl.root.RootModuleImpl
import com.makeevrserg.astralearner.di.impl.root.ServicesModuleImpl
import com.makeevrserg.astralearner.features.ui.splash.ComposeApplication
import com.makeevrserg.astralearner.navigation.DefaultRootComponent
import com.makeevrserg.mobile.di.getValue

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val rootModule by RootModuleImpl
    private val servicesModule by ServicesModuleImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AstraLearner)
        val componentContext = defaultComponentContext()
        val rootComponent = DefaultRootComponent(componentContext, rootModule, servicesModule)
        setContent {
            ComposeApplication(
                component = rootComponent,
                preferencesDataSource = servicesModule.localPreferenceModule.provide()
            )
        }
    }
}
