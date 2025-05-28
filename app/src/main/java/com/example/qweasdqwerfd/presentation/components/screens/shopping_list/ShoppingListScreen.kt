package com.example.qweasdqwerfd.presentation.components.screens.shopping_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qweasdqwerfd.dialog.MainDialog

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    Text("ListScreen")
    MainDialog(viewModel)
}