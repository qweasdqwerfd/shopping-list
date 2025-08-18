package com.example.qweasdqwerfd.presentation.components.screens.shopping_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.qweasdqwerfd.dialog.MainDialog
import com.example.qweasdqwerfd.view_model.ShoppingListViewModel

@Composable
fun ShoppingListScreen(
    viewModel: ShoppingListViewModel = hiltViewModel()
) {
    val itemsList = viewModel.list.collectAsState(initial = emptyList())
    LaunchedEffect() { }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(itemsList.value) {
            UiShoppingListItem(it) { event ->

                viewModel.onEvent(event)
            }
        }

    }
    MainDialog(viewModel)
}