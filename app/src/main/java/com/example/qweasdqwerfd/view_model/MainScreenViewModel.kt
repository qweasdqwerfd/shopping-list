package com.example.qweasdqwerfd.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qweasdqwerfd.main.MainScreenEvent
import com.example.qweasdqwerfd.dialog.DialogController
import com.example.qweasdqwerfd.dialog.DialogEvent
import com.example.qweasdqwerfd.local_data.data.model.ShoppingListItem
import com.example.qweasdqwerfd.local_data.data.repository.ShoppingListRepository
import com.example.qweasdqwerfd.presentation.components.screens.shopping_list.ShoppingListEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: ShoppingListRepository
) : ViewModel(), DialogController {


    override var dialogTitle = mutableStateOf("List name:")
        private set

    override var editableText = mutableStateOf("")
        private set

    override var openDialog = mutableStateOf(false)
        private set

    override var showEditableText = mutableStateOf(true)
        private set

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnItemSave -> {
                if (editableText.value.isEmpty()) return
                viewModelScope.launch {
                    repository.insertItem(
                        ShoppingListItem(
                            null,
                            editableText.value,
                            "",
                            0,
                            0
                        )
                    )
                }
            }
            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true
            }

        }
    }

    override fun onDialogEvent(event: DialogEvent) {
        when (event) {
            is DialogEvent.OnTextChange -> {
                editableText.value = event.text
            }
            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editableText.value = ""
            }
            is DialogEvent.OnConfirm -> {
                onEvent(MainScreenEvent.OnItemSave)
                openDialog.value = false
                editableText.value = ""
            }
        }
    }


}