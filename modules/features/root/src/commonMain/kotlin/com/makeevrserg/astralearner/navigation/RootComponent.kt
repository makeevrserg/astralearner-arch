package com.makeevrserg.astralearner.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
typealias Stack = Value<ChildStack<RootScreen, RootConfiguration>>
interface RootComponent : BackHandlerOwner {
    val childStack: Stack
    fun push(screen: RootScreen)
    fun replaceCurrent(screen: RootScreen)
    fun replaceAll(screen: RootScreen)
    fun pop()
}
