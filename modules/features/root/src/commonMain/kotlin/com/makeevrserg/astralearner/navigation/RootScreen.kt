package com.makeevrserg.astralearner.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

/**
 * All screen navigation is stored here
 */
sealed interface RootScreen : Parcelable {
    @Parcelize
    object Splash : RootScreen
}
