package com.example.qweasdqwerfd.ui_components.screens.shopping_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qweasdqwerfd.dialog.DialogController
import com.example.qweasdqwerfd.dialog.DialogEvent
import com.example.qweasdqwerfd.local_data.data.ShoppingListItem
import com.example.qweasdqwerfd.local_data.data.ShoppingListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository,
) : ViewModel(), DialogController {

    private var listItem: ShoppingListItem? = null

    override var dialogTitle = mutableStateOf("")
        private set

    override var editableText = mutableStateOf("")
        private set

    override var openDialog = mutableStateOf(false)
        private set

    override var showEditableText = mutableStateOf(false)
        private set


    fun onEvent(event: ShoppingListEvent) {
        when (event) {
            is ShoppingListEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            id = listItem?.id,
                            name = editableText.value,
                            time = "TODO()",
                            allItemsCount = listItem?.allItemsCount ?: 0,
                            allSelectedItemsCount = listItem?.allItemsCount ?: 0
                        )
                    )
                }
            }

            is ShoppingListEvent.OnItemClick -> {

            }

            is ShoppingListEvent.OnShowEditDialog -> {
                listItem = event.item
            }

            is ShoppingListEvent.OnShowDeleteDialog -> {

            }
        }
    }

    fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {

            }
            is DialogEvent.OnConfirm -> {

            }
            is DialogEvent.OnTextChange -> {

            }
        }
    }


}