package com.example.qweasdqwerfd.presentation.components.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qweasdqwerfd.presentation.custom_components.dialog.MainDialog
import com.example.qweasdqwerfd.presentation.components.bottom_bar.BottomBar
import com.example.qweasdqwerfd.presentation.custom_components.floating_action_button.FloatActionBar
import com.example.qweasdqwerfd.presentation.custom_components.status_bar.StatusBar
import com.example.qweasdqwerfd.presentation.navigation.NavGraph

@Composable
fun MainScreen(
    mainNavHostController: NavHostController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    StatusBar()
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatActionBar {
                viewModel.onEvent(MainScreenEvent.OnShowEditDialog)
            }
        },

        ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(navController) { route ->
                mainNavHostController.navigate(route)
            }
            MainDialog(viewModel)
        }
    }
}