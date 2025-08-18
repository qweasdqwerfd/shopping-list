package com.example.qweasdqwerfd.main

sealed class MainScreenEvent {
    object OnShowEditDialog: MainScreenEvent()
    object OnItemSave: MainScreenEvent()
}