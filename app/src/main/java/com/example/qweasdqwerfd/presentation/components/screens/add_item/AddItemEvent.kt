package com.example.qweasdqwerfd.presentation.components.screens.add_item

import com.example.qweasdqwerfd.local_data.data.model.AddItem

sealed class AddItemEvent {
    data class OnDelete(val item: AddItem): AddItemEvent()
    data class OnShowEditDialog(val item: AddItem): AddItemEvent()
    data class OnTextChange(val text: String): AddItemEvent()
    data class OnCheckedChange(val item: AddItem):  AddItemEvent()
    object OnItemSave: AddItemEvent()
}