package com.makeevrserg.astralearner.features.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.makeevrserg.astralearner.features.logic.splash.SplashComponent
import com.makeevrserg.astralearner.navigation.DefaultRootComponent
import com.makeevrserg.astralearner.resources.MR
import com.makeevrserg.astralearner.utils.asPainter
import com.makeevrserg.astralearner.utils.ui.theme.AppTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SplashScreenComponent(
    splashComponent: SplashComponent,
    rootComponent: DefaultRootComponent
) {
    LaunchedEffect(key1 = Unit) {
        splashComponent.screenChannelFlow.collectLatest {
            val screen = when (it) {
                is SplashComponent.Label.InitialLaunch -> Unit
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(AppTheme.materialColor.primaryVariant),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = MR.images.ic_splash.asPainter(),
            modifier = Modifier.size(256.dp),
            contentDescription = null
        )
    }
}
