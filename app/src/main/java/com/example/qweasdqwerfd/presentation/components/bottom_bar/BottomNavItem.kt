package com.example.qweasdqwerfd.presentation.components.bottom_bar

import com.example.qweasdqwerfd.R

sealed class BottomNavItem(
    val title: String,
    val iconId: Int,
    val route: String,
) {
    object ListItem : BottomNavItem(
        "list",
        R.drawable.list,
        "list"
    )

    object NoteItem : BottomNavItem(
        "note",
        R.drawable.note,
        "note"
    )

    object AboutItem : BottomNavItem(
        "about",
        R.drawable.about,
        "about"
    )

    object SettingItem : BottomNavItem(
        "setting",
        R.drawable.settings,
        "setting"
    )
}