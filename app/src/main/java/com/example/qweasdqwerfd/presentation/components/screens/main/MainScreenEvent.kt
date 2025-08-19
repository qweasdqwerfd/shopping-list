package com.example.qweasdqwerfd.presentation.components.screens.main

sealed class MainScreenEvent {
    object OnShowEditDialog: MainScreenEvent()
    object OnItemSave: MainScreenEvent()
}