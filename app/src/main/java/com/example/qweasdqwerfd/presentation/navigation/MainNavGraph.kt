package com.example.qweasdqwerfd.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.qweasdqwerfd.presentation.components.screens.main.MainScreen
import com.example.qweasdqwerfd.presentation.components.screens.add_item.AddItemScreen
import com.example.qweasdqwerfd.presentation.components.screens.shopping_list.inner.NewNoteScreen

@Composable
fun MainNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.route
    ) {

        composable(Screen.ADD_ITEM.route + "/{listId}") {
            AddItemScreen()
        }
        composable(Screen.NEW_NOTE.route) {
            NewNoteScreen()
        }
        composable(Screen.MAIN.route) {
            MainScreen(navController)
        }
    }
}