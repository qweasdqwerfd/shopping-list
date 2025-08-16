package com.example.qweasdqwerfd.presentation.components.screens.shopping_list

import com.example.qweasdqwerfd.local_data.data.model.ShoppingListItem

sealed class ShoppingListEvent {
    data class OnShowDeleteDialog(val item: ShoppingListItem): ShoppingListEvent()
    data class OnShowEditDialog(val item: ShoppingListItem): ShoppingListEvent()
    data class OnItemClick(val route: String): ShoppingListEvent()
    object OnItemSave: ShoppingListEvent()
}