package com.example.qweasdqwerfd

sealed class UIEvent {
    object PopBackStack: UIEvent()
    data class Navigate(val route: String): UIEvent()
    data class ShowSnackBar(val message: String): UIEvent()
}