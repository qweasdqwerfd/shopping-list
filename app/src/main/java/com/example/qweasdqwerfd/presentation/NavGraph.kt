package com.example.qweasdqwerfd.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qweasdqwerfd.presentation.components.screens.AboutScreen
import com.example.qweasdqwerfd.presentation.components.screens.shopping_list.ShoppingListScreen
import com.example.qweasdqwerfd.presentation.components.screens.NoteScreen
import com.example.qweasdqwerfd.presentation.components.screens.SettingScreen
import com.example.qweasdqwerfd.presentation.components.screens.shopping_list.ShoppingListViewModel

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "list"
    )  {
        composable("list") { backStackEntry ->
            val viewModel: ShoppingListViewModel = hiltViewModel(backStackEntry)
            ShoppingListScreen(viewModel)
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