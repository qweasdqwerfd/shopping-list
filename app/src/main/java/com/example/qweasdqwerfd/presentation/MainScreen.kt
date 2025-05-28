package com.example.qweasdqwerfd.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qweasdqwerfd.presentation.custom_components.floating_action_button.FloatActionBar
import com.example.qweasdqwerfd.presentation.custom_components.status_bar.StatusBar
import com.example.qweasdqwerfd.presentation.components.bottom_bar.BottomBar

@Composable
fun MainScreen() {
    StatusBar()
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController) },
        floatingActionButtonPosition = FabPosition.Center,

        floatingActionButton = {
            FloatActionBar()
        },


        ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(
                navController
            )
        }
    }
}