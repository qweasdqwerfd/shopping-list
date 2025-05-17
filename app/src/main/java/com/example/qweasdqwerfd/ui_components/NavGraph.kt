package com.example.qweasdqwerfd.ui_components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qweasdqwerfd.ui_components.screens.AboutScreen
import com.example.qweasdqwerfd.ui_components.screens.shopping_list.ShoppingListScreen
import com.example.qweasdqwerfd.ui_components.screens.NoteScreen
import com.example.qweasdqwerfd.ui_components.screens.SettingScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "list"
    )  {
        composable("list") {
            ShoppingListScreen()
        }
        composable("note") {
            NoteScreen()
        }
        composable("about") {
            AboutScreen()
        }
        composable("setting") {
            SettingScreen()
        }
    }
}