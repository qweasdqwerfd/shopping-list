package com.example.qweasdqwerfd.presentation.components.screens.shopping_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qweasdqwerfd.UIEvent
import com.example.qweasdqwerfd.dialog.DialogController
import com.example.qweasdqwerfd.dialog.DialogEvent
import com.example.qweasdqwerfd.local_data.data.ShoppingListItem
import com.example.qweasdqwerfd.local_data.data.ShoppingListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: ShoppingListRepository,
) : ViewModel(), DialogController {

    private val list = repository.getAllItems()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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
                sendUIEvent(UIEvent.Navigate(event.route))
            }

            is ShoppingListEvent.OnShowEditDialog -> {
                openDialog.value = true
                dialogTitle.value = "List name:"
                listItem = event.item
                editableText.value = listItem?.name ?: ""

                showEditableText.value = true

            }

            is ShoppingListEvent.OnShowDeleteDialog -> {
                openDialog.value = true
                dialogTitle.value = "Delete this item?"
                listItem = event.item

                showEditableText.value = false
            }
        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }

            is DialogEvent.OnConfirm -> {
                if (showEditableText.value == true) {
                    onEvent(ShoppingListEvent.OnItemSave)
                } else {
                    viewModelScope.launch {
                        repository.deleteItem(listItem!!)
                    }
                }
                openDialog.value = false
            }

            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
        }
    }

    private fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }


}