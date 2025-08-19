package com.example.qweasdqwerfd.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qweasdqwerfd.presentation.components.screens.AboutScreen
import com.example.qweasdqwerfd.presentation.components.screens.NoteScreen
import com.example.qweasdqwerfd.presentation.components.screens.SettingScreen
import com.example.qweasdqwerfd.presentation.components.screens.shopping_list.ShoppingListScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    onNavigate: (String) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.LIST.route
    ) {
        composable(Screen.LIST.route) {
            ShoppingListScreen { route ->
                onNavigate(route)
            }
        }

        composable(Screen.NOTE.route) {
            NoteScreen()
        }
        composable(Screen.ABOUT.route) {
            AboutScreen()
        }
        composable(Screen.SETTING.route) {
            SettingScreen()
        }
    }
}