package com.makeevrserg.astralearner.features.ui.splash

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import com.makeevrserg.astralearner.navigation.DefaultRootComponent
import com.makeevrserg.astralearner.storage.LocalPreferenceSource
import com.makeevrserg.astralearner.utils.ui.theme.AppTheme
import com.makeevrserg.astralearner.utils.ui.theme.LocalAppTheme

@Composable
fun ComposeApplication(
    component: DefaultRootComponent,
    preferencesDataSource: LocalPreferenceSource
) {
    CompositionLocalProvider(
        LocalAppTheme provides AppTheme.DefaultDarkTheme,
        content = {
            MaterialTheme(
                colors = LocalAppTheme.current.materialColor,
                typography = LocalAppTheme.current.typography,
                shapes = LocalAppTheme.current.shapes,
                content = {
                    ApplicationContent(component)
                }
            )
        }
    )
}
