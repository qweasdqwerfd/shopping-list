package com.example.qweasdqwerfd.presentation.navigation

sealed class Screen {
    object LIST : Screen()
    object NOTE : Screen()
    object ABOUT : Screen()
    object SETTING : Screen()
    object MAIN: Screen()
    object NEW_NOTE: Screen()
    object ADD_ITEM: Screen()

    val route: String
        get() = this::class.simpleName!!.lowercase()
}
