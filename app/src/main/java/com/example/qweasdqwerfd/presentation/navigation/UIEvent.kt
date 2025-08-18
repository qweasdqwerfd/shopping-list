package com.example.qweasdqwerfd.presentation.navigation

sealed class UIEvent {
    object PopBackStack: UIEvent()
    data class Navigate(val route: String): UIEvent()
    data class ShowSnackBar(val message: String): UIEvent()
}